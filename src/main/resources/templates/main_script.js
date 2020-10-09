let change_buttons = document.querySelectorAll('.btn-ed-del');


	for(let i = 0; i < change_buttons.length; i++){
		change_buttons[i].addEventListener("click", function (e) {
		console.log(e.target);
		let current_id = e.id;
		});
	}
	



let theads = document.querySelectorAll('th.tmark');
console.log(theads);




let place = document.getElementById('place-elem');


for(let i = 0; i <= 7; i++){

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
	input.value = 


	place.appendChild(inner_place);
	inner_place.appendChild(label);
	inner_place.appendChild(input);

}