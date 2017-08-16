layout 'layout.tpl', title: 'Deprecations : View all',
	
content: contents {
	div(class:'container') {
	
    	div(class:'pull-right') {
        	a(href:'/?form', 'Create Deprecation')
      	}
   
      
      	table(class:'table table-bordered table-striped') {
        	thead {
          		tr {
            		td 'ID'
            		td 'Capital'
            		td 'Interest'
            		td 'Created'
            		td 'Action'
          		}
        	}
        	tbody {
          		if (deprecations.empty) { 
          			tr { 
          				td(colspan:'5', 'No Deprecations' ) 
          			} 
          		}
          		deprecations.each { deprecation ->
            		tr { 
              			td deprecation.id
              			td "${deprecation.capital}"
              			td "${deprecation.interest}"
              			td "${deprecation.created}"
              			td { a(href:"/$deprecation.id", class:'btn btn-default', 'Select') } 
            		}
          		}
        	}
    	}
    	
    	if(null != deprecation) {
	      		      	
	      	div(class:'panel panel-default') {
	      		div(class:'panel-heading', 'Selected Deprecation')
	      		div(class:'panel-body') {
			      	dl (class:'dl-horizontal') {
			        	dt 'ID'
			        	dd(id:'id', "${deprecation.id}")
			        	
			        	dt 'Capital'
			        	dd(id:'capital', "${deprecation.capital}")
			        	
			        	dt 'Interest'
			        	dd(id:'interest', "${deprecation.interest}")
			        	
			        	dt 'Date'
			        	dd(id:'created', "${deprecation.created}")
			      	}
		      	}
	      	}
		}
	}
}