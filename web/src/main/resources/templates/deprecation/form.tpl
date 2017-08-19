layout 'layout.tpl', title: 'Deprecations : Create', content: contents {
	div (class:'container') {
  	
  		form (id:'deprecationForm', action:'/app/', method:'post') {
  	
  			if (formErrors) {
      			div(class:'alert alert-danger') {
        			formErrors.each { error -> p error.defaultMessage }
      			}
    		}
    
    		div(class:fieldErrors?.capital ? 'form-group has-error' : 'form-group') {
        		label (for:'capital', 'Capital')
        		input (name:'capital', type:'number', value:deprecation.capital?:'', class:'form-control')
    		}
    		
    		div(class:fieldErrors?.interest ? 'form-group has-error' : 'form-group') {
        		label (for:'interest', 'Interest')
        		input (name:'interest', type:'number', value:deprecation.interest?:'', class:'form-control')     
    		}

    		div (class:'form-actions') {
          		input (type:'submit', value:'Create')
        	}
  		}
	}
}