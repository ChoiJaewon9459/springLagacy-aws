function updateState(){
	//input_tag is Array
	let inputTag = document.querySelectorAll('input');
	for (var i = 0; i < inputTag.length; i++) {
		inputTag[i].readOnly = false;
	}
	
	let updateButton = document.querySelector('.updateButton');
	updateButton.innerHTML = "<button type='submit' form='boardForm'>수정완료</button>";
}