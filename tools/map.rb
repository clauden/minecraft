require 'csv'


FUNC_MAPFILE = "methods.csv"
FIELD_MAPFILE = "fields.csv"


# find a function name in source
funcrx = /func_[0-9a-zA-Z_]+/
fieldrx = /field_[0-9a-zA-Z_]+/


# load up the maps
func_map = {}
CSV.foreach(FUNC_MAPFILE) do |fields|
	func = fields[0]
	name = fields[1]
	STDERR.puts "mapping func #{func} -> #{name}"
	func_map[func] = name
end
   
field_map = {}
CSV.foreach(FIELD_MAPFILE) do |fields|
	field = fields[0]
	name = fields[1]
	STDERR.puts "mapping field #{field} -> #{name}"
	field_map[field] = name
end
   
# main loop
s = $stdin
s.each do |l|

	# clean up prefix line number comments
	s = l.sub(/\/\*\s+[0-9:\s]+\*\/\s/, "")

	# clean up newlines
	s = s.sub(/\r$/, "")

	# grab as many funcs as there are to be found
	m_func = s.scan(funcrx)
	m_field = s.scan(fieldrx)

	# echo non-mapped lines
	if m_func.nil? and m_field.nil?
		puts s
		next
	end

	# step through all the funcs found on line
	for func in m_func
		STDERR.puts "found #{func}"	

		name = func_map[func]
		if name.nil?
			STDERR.puts "no map for #{func}"
			next
		end
		
		# ok we have a name, now sub it back into the line...
		STDERR.puts "map #{func} -> #{name}"
		s = s.sub(func, name)
	end	

	# step through all the fields
	for field in m_field
		STDERR.puts "found #{field}"	

		name = field_map[field]
		if name.nil?
			STDERR.puts "no map for #{field}"
			next
		end
		
		# ok we have a name, now sub it back into the line...
		STDERR.puts "map #{field} -> #{name}"
		s = s.sub(field, name)
	end	

	# all done
	STDERR.puts "result is \'#{s}\'"
	puts s
end
