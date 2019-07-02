var Controller = (function() {


	var addButtonClickEvent = function(textTrigger, event) {
		var model = this;
		var value = textTrigger.value.trim();
		if(value.length) {
			if(model.notDuplicate(value)) {

				model.Add(value);
				textTrigger.value = null;

			} else {
				alert("Duplicate Value");
			}
		};
	
	};


	var deleteButtonClickEvent = function(event) {
		var model = this;
		if(event.target.type == "button") {
			model.Delete(event.target.value);
		
		}
	
	}

	var constructor = function() {

		var scopeEl;
		var model;
		var view;

		this.init = function(el, m, v) {
			scopeEl = el;
			model = m;
			view = v;
			model.setScope(el);
			model.setView(view);
			model.registerWidget(view.listView());
			model.registerWidget(view.summaryView());
			model.refreshWidgets(view, model);

			//var testing = document.getElementsByClassName("")
			
			
			var addButton = view.triggerField().getButtonInstance(el);
			var textTrigger = view.triggerField().getTextInstance(el);


			//by John Mills
			//finished at 11:45am
			textTrigger.addEventListener("keypress", function(event){

				var myBtn = document.getElementById("addBtn");

				if(event.keyCode === 13){
					addButton.click();
				}

			});

			addButton.addEventListener("click", addButtonClickEvent.bind(model, textTrigger));
			
			var listViewEl = scopeEl.getElementsByClassName('listWrapper')[0];
			listViewEl.addEventListener("click", deleteButtonClickEvent.bind(model));
			
		};
		
	};
	
	return new constructor();
	
});