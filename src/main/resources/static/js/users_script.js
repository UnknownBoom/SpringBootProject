let selects1 = document.querySelectorAll("select#rolesSelect1");
let selects3 = document.querySelectorAll("select#rolesSelect3");

let delete_buttons = document.querySelectorAll('.btn-del');


console.log(selects1);
console.log(selects3);


let roles_event_listener1 = function(e) {
    let input1 = document.querySelectorAll("input#rolesData1");
    let value = $("#rolesSelect1 option:selected").val().toLowerCase();
    input1.setAttribute("value",value);
    //input1.value = $("#rolesSelect1 option:selected").val().toLowerCase();
    console.log(input1);
    console.log(input1.value);


};

let del_event_listner = function(e){
    let tr = e.target.parentElement.parentElement.parentElement;
    console.log(tr, arguments);
    console.log(tr.querySelectorAll('td')[0].innerText);
    let tr_id = tr.querySelectorAll('td')[0].innerText;

    let place = document.getElementById('placeElem2');
    let input = document.createElement('input');
    let next_sibling = document.getElementById("placeBefore");
    input.name = "user_id";
    input.value = tr.id;
    input.className = 'hidden-el';
    console.log(input.value);

    place.insertBefore(input, next_sibling);
}

let roles_event_listener3 = function(e) {
    let input3 = document.querySelectorAll("input#rolesData3");
    let value = $("#rolesSelect1 option:selected").val().toLowerCase();
    input3.setAttribute("value",value);
    //input3.value = $("#rolesSelect3 option:selected").val().toLowerCase();
    console.log(input3);
    console.log(input3.value);


};

for(let i = 0; i < selects1.length; i++){
    selects1[i].addEventListener('change', roles_event_listener1);
}
for(let i = 0; i < selects3.length; i++){
    selects3[i].addEventListener('change', roles_event_listener3);
}
for(let i = 0; i < delete_buttons.length; i++){
    delete_buttons[i].addEventListener('click', del_event_listner);
}





