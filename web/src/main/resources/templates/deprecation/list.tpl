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
          		}
        	}
        	tbody {
          		if (deprecations.empty) { 
          			tr { 
          				td(colspan:'4', 'No Deprecations' ) 
          			} 
          		}
          		deprecations.each { deprecation ->
            		tr { 
              			td deprecation.id
              			td "${deprecation.capital}"
              			td "${deprecation.interest}"
              			td "${deprecation.created}"
            		}
          		}
        	}
    	}
	}
}