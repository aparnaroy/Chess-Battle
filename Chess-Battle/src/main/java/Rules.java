/**
 * This class represents the set of rules for each type of Piece.
 * @author Benita Abraham
 * @version 04/30/22
 */

public class Rules {
    /**
     * This method checks if the valid indicated is valid
     * @param game game that is being played
     * @param fromRow row index of Piece making Action (From Square)
     * @param fromCol column index of Piece making Action (From Square)
     * @param toRow row index of second board square chosen by player (To Square)
     * @param toCol column index of second board square chosen by player (To Square)
     * @param action action type chosen by player
     * @return boolean whether the action is valid
     */
    public static boolean checkValidAction(GameS22 game,int fromRow, int fromCol, int toRow, int toCol, char action){
        if(!(game.getGameBoard().inBounds(fromRow, fromCol) && game.getGameBoard().inBounds(toRow, toCol))){
            return false;
        }
        if(game.getGameBoard().getSquares()[fromRow][fromCol].isEmpty()){
            return false;
        }
        if(!(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().getTeamColor().
                equals(game.getCurrentTeam().getTeamColor()))) {
            return false;
        }
        if(action == 'M'){
            if(!(game.getGameBoard().getSquares()[toRow][toCol].isEmpty())) {
                return false;
            }
            if(!game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().
                    validMovePath(fromRow, fromCol, toRow, toCol)){
                return false;
            }

        }else if(action == 'S'){
            if(!(game.getGameBoard().getSquares()[toRow][toCol].isEmpty())) {
                return false;
            }
            if(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceBuzz){
                return false;
            }
            if(!game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().canSpawn()){
                return false;
            }
            if(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceMinion &&
                    !(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceEvilMinion)){
                if(fromRow < 4){
                    if(toRow != 0){
                        return false;
                    }
                }else {
                    if(toRow != 7){
                        return false;
                    }
                }
                if(fromCol < 4){
                    if(toCol != 0){
                        return false;
                    }
                } else {
                    if(toCol != 7){
                        return false;
                    }
                }
            }
            if(!game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().
                    validSpawnPath(fromRow, fromCol, toRow, toCol)){
                return false;
            }
        } else if(action == 'R'){
            if(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceBuzz){
                return false;
            }
            if(game.getGameBoard().getSquares()[toRow][toCol].isEmpty()){
                return false;
            }
            if(game.getGameBoard().getSquares()[toRow][toCol].getPiece().getTeamColor().
                    equals(game.getCurrentTeam().getTeamColor())){
                return false;
            }
            if(!game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().
                    validRecruitPath(fromRow, fromCol, toRow, toCol)){
                return false;
            }
        } else if(action == 'A'){
            if(game.getGameBoard().getSquares()[toRow][toCol].isEmpty()){
                return false;
            }
            if(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceMinion &&
                    !(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceEvilMinion)){
                return false;
            }
            if(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceBuzz){
                if (!((PieceBuzz) game.getGameBoard().getSquares()[fromRow][fromCol].getPiece()).canAttack()) {
                    return false;
                }
            }
            if(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PiecePowerpuff){
                if(game.getGameBoard().getSquares()[fromRow][fromCol-1].getPiece() instanceof PiecePowerpuff ||
                        game.getGameBoard().getSquares()[fromRow][fromCol+1].getPiece() instanceof PiecePowerpuff){
                    return false;
                }
            }
            if(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceEvilMinion ) {

                if(!((PieceEvilMinion) game.getGameBoard().getSquares()[fromRow][fromCol].getPiece()).canAttack()){
                    return false;
                }
                if(game.getGameBoard().getSquares()[toRow][toCol].getPiece().getTeamColor().
                        equals(game.getCurrentTeam().getTeamColor()) &&
                        !(game.getGameBoard().getSquares()[toRow][toCol].getPiece() instanceof PieceMinion)){
                    return false;
                }
            } else if(game.getGameBoard().getSquares()[toRow][toCol].getPiece().getTeamColor().
                    equals(game.getCurrentTeam().getTeamColor())){
                return false;
            }
            if(!game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().
                    validAttackPath(fromRow, fromCol, toRow, toCol)){
                return false;
            }
        }
        // New Action Modification
        else if (action == 'W'){
            if(!(game.getGameBoard().getSquares()[toRow][toCol].isEmpty())) {
                return false;
            }
            if(!game.getGameBoard().getSquares()[fromRow][fromCol].getPiece().
                    validMoonwalkPath(fromRow, fromCol, toRow, toCol)){
                return false;
            }
            if(!(game.getGameBoard().getSquares()[fromRow][fromCol].getPiece() instanceof PieceSpanishBuzz)){
                return false;
            }
            if(!(((PieceSpanishBuzz) game.getGameBoard().getSquares()[fromRow][fromCol].getPiece()).canMoonwalk())){
                return false;
            }
        }
        return true;
    }
}