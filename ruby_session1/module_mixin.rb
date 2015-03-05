module Debug  
 
     def percentage(a)
      


per=(a/600)*100

puts per
  end

 def interest(a,b,c)
      
   
  intrest=(a*b*c)/100
  puts intrest
   end
  
end  
  
class Percentage  
 
  include Debug  
    


end  
  
class Interest  
  include Debug 


end  
  
puts "Enter score of student"
a = gets.chomp.to_i
puts "Enter principle amount"
   b = gets.chomp.to_i
   puts "Enter time"
   c = gets.chomp.to_i
   puts "Enter interest rate"
   d = gets.chomp.to_i

pr = Percentage.new()  
si = Interest.new()  
puts pr.percentage(a)  
puts si.interest(b,c,d)

