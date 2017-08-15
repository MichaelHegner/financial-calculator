layout 'layout.tpl', title: 'Deprecations : Create',
  	content: contents {
		div (class:'container') {
      	
      		form (id:'deprecationForm', action:'/', method:'post') {
      	
      			if (formErrors) {
          			div(class:'alert alert-error') {
            			formErrors.each { error -> p error.defaultMessage }
          			}
        		}
        
        		div (class:'pull-right') {
          			a(href:'/', 'Deprecations')
        		}
        
        		label (for:'capital', 'Capital')
        		input (name:'capital', type:'number', value:deprecation.capital?:'', class:fieldErrors?.capital ? 'field-error' : 'none')
        
        		label (for:'interest', 'Interest')
        		input (name:'interest', type:'number', value:deprecation.interest?:'', class:fieldErrors?.interest ? 'field-error' : 'none')     
        
        		div (class:'form-actions') {
          		input (type:'submit', value:'Create')
        	}
      	}
    }
}