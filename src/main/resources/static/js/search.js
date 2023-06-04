let timeoutID = null;

function findMember(str) {
    console.log('search: ' + str)
}

$('#target').keyup(function(e) {
    clearTimeout(timeoutID);
    const value = e.target.value
    timeoutID = setTimeout(() => findMember(value), 500)
});