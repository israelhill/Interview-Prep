/*
    Dynamic Programming: How many paths are there from the top leeft index
    to the bottom right index if we can only move down or right?
    Squares marked with -1 cannot be included in the path. We must go around
    these squares.
*/

var row = 4;
var col = 4;
var lookupTable = new Array(4);
var board = [
    [0, 0, 0, -1],
    [0, 0, 0, -1],
    [0, -1, 0, 0],
    [0, 0, 0, 0]
];

function initLookupTable() {
    for(let i = 0; i < row; i++) {
        lookupTable[i] = new Array(4);
    }
    // initialize lookup table last index to be 1
    // (this is the tile we wish to reach)
    lookupTable[row-1][col-1] = 1;
}

function countPathsFromNeighbors(currentRow, currentCol) {
    return lookDown(currentRow, currentCol) + lookRight(currentRow, currentCol);
}

function lookDown(currentRow, currentCol) {
    if(currentRow + 1 >= row) {
        // check that bottom neighbor is not out of bounds
        return 0;
    }
    else if(board[currentRow + 1][currentCol] == -1) {
        // check that neighbor is not a blocked out index
        return 0;
    }
    else {
        return lookupTable[currentRow + 1][currentCol];
    }
}

function lookRight(currentRow, currentCol) {
    if(currentCol + 1 >= col) {
        // check that right neighbor is not out of bounds
        return 0;
    }
    else if(board[currentRow][currentCol + 1] == -1) {
        return 0;
    }
    else {
        return lookupTable[currentRow][currentCol+1];
    }
}

function main() {
    initLookupTable();
    for(let r = row-1; r >= 0; r--) {
        for(let c = col-1; c >= 0; c--) {
            if(board[r][c] == -1 || (r == row-1 && c == col-1)) {
                // do nothing: this tile is blocked off or the destination tile
            }
            else {
                lookupTable[r][c] = countPathsFromNeighbors(r, c);
            }
        }
    }
    console.log('Number of Paths from top left to bottom right: ' + lookupTable[0][0]);
}

main();
