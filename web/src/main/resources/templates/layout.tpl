html 
{
	head 
	{
		title(title)
	    link(rel:'stylesheet', href:'/css/deprecation.css')
	    link(rel:'stylesheet', href:'/css/bootstrap.min.css')
	    link(rel:'stylesheet', href:'//cdn.jsdelivr.net/chartist.js/latest/chartist.min.css')
	 
		script(src:'https://code.jquery.com/jquery-1.12.4.min.js'){}
		script(src:'//cdn.jsdelivr.net/chartist.js/latest/chartist.min.js'){}
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
				          		a(href:'/app/') { yield 'Deprecations' }
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