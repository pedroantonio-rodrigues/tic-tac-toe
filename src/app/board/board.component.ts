import { Component } from '@angular/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent {

  // inicializa o primeiro jogador
  currentPlayer: string = 'X';

  // inicializando o tabuleiro
  board: string[][] = [

    ['', '', ''],
    ['', '', ''],
    ['', '', '']

  ];

  winner: string | null = null;
  draw: boolean = false


  makeMove (line: number, column: number){
    if (this.winner && !this.draw && this.board[line][column] == '')
    this.board[line][column] = this.currentPlayer;
    this.checkWinner();
    this.checkDraw();

    // Alterna entre os jogadores
    this.currentPlayer = this.currentPlayer === 'X' ? 'O' : 'X';
  }

  checkWinner() {

    const line = this.board;
    const column = this.board[0].map((_, i) => this.board.map(row => row[i]));
    const diagonal = [
      [this.board[0][0], this.board[1][1], this.board[2][2]],
      [this.board[0][2], this.board[1][1], this.board[2][0]]
      ];

      const allLines = [...line, ...column, ...diagonal];

      for (const line of allLines){
        if(line.every(cell => cell ==='X')){
          this.winner = 'X';
          return;
        } else if (line.every(cell => cell === 'O')){
          this.winner = 'O';
          return;
        }
      }
  }

  checkDraw() {
    if(!this.winner && this.board.every(row => row.every(cell => cell !== ''))){
      this.draw = true;
    }
  }

  restartGame(){
    this.currentPlayer = 'X';
    this.board = [

      ['', '',''],
      ['', '',''],
      ['', '','']

    ];
    this.winner = null;
    this.draw = false;
  }
}

