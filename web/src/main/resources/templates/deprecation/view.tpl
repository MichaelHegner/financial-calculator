layout 'layout.tpl', title:'Messages : View',
	content: contents {
    div(class:'container') {

      	div(class:'pull-right') {
        	a(href:'/', 'Deprecations')
      	}
      
      	dl {
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