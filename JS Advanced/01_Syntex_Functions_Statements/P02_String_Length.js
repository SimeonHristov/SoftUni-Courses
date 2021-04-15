//solution 1
function stringLength (a,b,c) {
    let sum = a.length + b.length + c.length;
    let avg = Math.floor(sum/3);
    console.log(sum);
    console.log(avg);
    
    //console.log(a.length + b.length + c.length);
    
}

stringLength('abv','qwert', 'aq');



//solution 2
function stringLength (...arr) {
    let total = arr.reduce((a,c) => a + c.length, 0);
    console.log(total);
    console.log(Math.floor(total / arr.length));
}


stringLength('abv','qwert', 'aq', 'abvqwe','qasdzxcwert', 'aasdqweqwdasq');

