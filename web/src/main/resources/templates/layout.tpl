html 
{
	head 
	{
		title(title)
	    link(rel:'stylesheet', href:'/css/bootstrap.min.css')
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