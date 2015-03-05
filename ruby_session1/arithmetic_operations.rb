puts "Enter A"
a = gets.chomp.to_i
puts "Enter B"
b = gets.chomp.to_i
puts "Enter operator"
op=gets.chomp
result=a.send(op,b)
puts result
