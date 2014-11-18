$(document).ready(function() { 

	//add aditional hover class to active submenu parent
	$('#primary-nav ul').find('ul').hover(function(){
		$(this).prev().toggleClass('hover');
	});

	//mobile menu form submission on select
    $('#mobileSelect').change(function () {
	    window.location = $(this).val();  
    });

    //stylesheet switcher + cookie
    if($.cookie("orange-html-css")) {
	    $("link[href*=color]").attr("href",$.cookie("orange-html-css"));
	    var themeClass = $.cookie("orange-html-css").split('-')[1];
		$('body').attr('class', 'theme-'+themeClass.split('.')[0])
	}
	$("#styleswitcher dd a").click(function() { 
		var themeClass = $(this).attr('rel').split('-')[1];
		$('body').attr('class', 'theme-'+themeClass.split('.')[0])
		$("link[href*=color]").attr("href",$(this).attr('rel'));
		$.cookie("orange-html-css",$(this).attr('rel'), {expires: 365, path: '/'});
		return false;
	});
	
	//init jQuery flexslider	
	
	
//	$('a[rel=lightbox]').fancybox({
//		'overlayShow'	: true,
//		'transitionIn'	: 'elastic',
//		'transitionOut'	: 'elastic'
//	});

	//init Nivo slider
//	
//	$('#nivoslider').nivoSlider();
	

});