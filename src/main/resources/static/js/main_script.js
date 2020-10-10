let change_buttons = document.querySelectorAll('.btn-ed-del');
let row_elements = [];
let theads = document.querySelectorAll('th.tmark');
console.log(theads);

let add_allow = true;

let place = document.getElementById('place-elem');

let btn_event_listener = function(e){
	let tr = e.target.parentElement.parentElement.parentElement;
	console.log(tr);
	row_elements = tr.querySelectorAll('td');
	console.log(row_elements);

	if(add_allow){
		for(let i = 0; i < theads.length; i++){
			let thead_id = theads[i].innerText.toLowerCase();

			let inner_place = document.createElement('div');
			inner_place.className = 'form-group';
			let label = document.createElement('label');
			label.className = "col-form-label";
			label.setAttribute('for',thead_id);
			label.innerText = thead_id;
			let input = document.createElement('input');
			input.setAttribute('type','text');
			input.className = "form-control";
			input.id = thead_id;
			if(i == 0){
				input.setAttribute('disabled','true');
			} 
			console.log(row_elements[i]);
			input.value = row_elements[i].innerHTML;

			place.appendChild(inner_place);
			inner_place.appendChild(label);
			inner_place.appendChild(input);
			add_allow = false;
		}
	}
}

	for(let i = 0; i < change_buttons.length; i++){
		change_buttons[i].addEventListener("click", btn_event_listener);
	}
