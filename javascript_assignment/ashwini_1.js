var temp_x_range;
var temp_y_range;
var eqn;
var graphJ = {


init: function(){
	

   eqn = prompt("enter the Equation");
   var pattern=new RegExp("[a-z 0-9]x[+|-][a-z|0-9]y[+|-][a-z 0-9]=0");
   
   if(eqn=="" || !(pattern.test(eqn)))
   {   
      alert("invalid");   
   }
   else
   {
		
      document.getElementById("result").style.display="block";
      
      
      var p=eqn.charAt(0);
      document.getElementById("xconst").value=p;
      var q=eqn.charAt(3);
      document.getElementById("yconst").value=q;
      var r=eqn.charAt(6);
      document.getElementById("const").value=r; 
   }   
 
},
 drawGraph: function(){

  var p=document.getElementById("xconst").value;  
  var q=document.getElementById("yconst").value;
  var r=document.getElementById("const").value;
   
   	
   temp_x_range = prompt("Please enter the X-Range");
   temp_y_range = prompt("Please enter the Y-Range");
   
   
  var xrange=parseInt(temp_x_range);
  var xstep=parseInt(temp_y_range); 
  if(xrange=="" || xstep=="")
  {
     alert("Enter the range of x and increment factor");
   }
  else
 {

   document.getElementById("graph").style.display="block";
  var xvalue=0;
  var yvalue=0;
     var canvas = document.getElementById("lineCanvas");
     var context = canvas.getContext('2d');
     context.beginPath();
     context.translate(150,150);
  for(xvalue=0;xvalue<xrange;xvalue=xvalue+xstep)
   {     
      yvalue=parseInt(((-r-(p*xvalue))/q));
      //context.moveTo(xvalue, yvalue);
      context.lineTo(xvalue,yvalue);
      context.stroke();    
     
   }
 }

  
}

};
