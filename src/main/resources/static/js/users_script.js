let selects1 = document.querySelectorAll("select#rolesSelect1");
let selects3 = document.querySelectorAll("select#rolesSelect3");

console.log(selects1);
console.log(selects3);


let input1 = document.querySelectorAll("input#rolesData1");
let input3 = document.querySelectorAll("input#rolesData3");
console.log(input1);
console.log(input3);

let roles_event_listener1 = function(e) {

    input1.value = $("#rolesSelect1 option:selected").val().toLowerCase();
    console.log(input1.value);


};
let roles_event_listener3 = function(e) {

    input3.value = $("#rolesSelect3 option:selected").val().toLowerCase();
    console.log(input3.value);


};

for(let i = 0; i < selects1.length; i++){
    selects1[i].addEventListener('change', roles_event_listener1);
}
for(let i = 0; i < selects3.length; i++){
    selects3[i].addEventListener('change', roles_event_listener3);
}





