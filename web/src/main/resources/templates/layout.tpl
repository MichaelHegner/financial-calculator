html 
{
	head 
	{
		title(title)
	    link(rel:'stylesheet', href:'/css/deprecation.css')
	    link(rel:'stylesheet', href:'/css/bootstrap.min.css')
	 
		script(src:'https://code.jquery.com/jquery-1.12.4.min.js'){}
	    script(src:'https://www.amcharts.com/lib/3/amcharts.js'){}
	    script(src:'https://www.amcharts.com/lib/3/serial.js'){}
	    script(src:'https://www.amcharts.com/lib/3/plugins/export/export.min.js'){}
	    link(rel:'stylesheet', href:'https://www.amcharts.com/lib/3/plugins/export/export.css', type:'text/css', media:'all')
	    script(src:'https://www.amcharts.com/lib/3/themes/none.js'){}
	    script(src:'/js/deprecation.js'){}
	    
	}
	body 
	{
		div(class:'container') 
		{
	    	nav(class:'navbar navbar-default') 
	    	{
	    		div(class:'container-fluid')
	    		{
		        	div(class:'navbar-header') 
		        	{
		          		a(class:'navbar-brand', href:'http://beta.groovy-lang.org/docs/groovy-2.3.0/html/documentation/markup-template-engine.html') 
		          		{
		              			yield 'Groovy - Layout'
		          		}
		          	}
		    	
			    	div(class:'collapse navbar-collapse')
			    	{
			    		ul(class:'nav navbar-nav') 
			    		{
			    			li
			    			{
				          		a(href:'/') { yield 'Deprecations' }
			    			}
			          	}
			    	}
		    	}
	    	}
	    	h1(title)
	    	div { content() }
	   	}
	}
}