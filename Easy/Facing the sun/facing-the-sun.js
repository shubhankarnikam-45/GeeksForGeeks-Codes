//{ Driver Code Starts
//Initial Template for javascript

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();
});

function readLine() {
    return inputString[currentLine++];
}

function printList(res,n){
    let s="";
    for(let i=0;i<n;i++){
        s+=res[i];
        s+=" ";
    }
    console.log(s);
}


function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let arr = new Array(n);
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<n;i++){
            arr[i] = input_ar1[i];
        }
        let obj = new Solution();
        let res = obj.countBuildings(arr, n);
        console.log(res);
        
    }
}// } Driver Code Ends


// } Driver Code Ends


//User function Template for javascript


/**
 * @param {number[]} h
 * @param {number} n
 * @returns {number}
*/

class Solution{
    countBuildings(arr,n){
        //cnt variable to store count.
    let cnt = 1;

    //stack.
    let stack = [];
    stack.push(arr[0]);

    //travers in array from 1st index.
    for(let i=1; i<n ; i++)
        {

            if(stack[stack.length-1] < arr[i]){
                //pop.
                stack.pop();
    
                //push
                stack.push(arr[i]);
    
                //cnt increase.
                cnt++;
            }
        }

    return cnt;
    }
}

