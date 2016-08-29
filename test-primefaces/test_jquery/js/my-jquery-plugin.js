(function($) {
  $.fn.withBorder = function(myBorderColorParam)
  {
	 var borderColor = myBorderColorParam;
	  if(borderColor == undefined){
		  borderColor = 'black';
	  } 
	  
    this.each(function() {
      //$(this).wrap('<b><i></i></b>');
	  $(this).css('border-width', '3px')
	         .css('border-color', borderColor)
			 .css('border-style','solid');
    });
    return this;
  };
})(jQuery);

