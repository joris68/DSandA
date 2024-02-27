package leetcode;

class Solution {
    public int romanToInt(String s) {

        int toReturn = 0;
        int i = 0;

        while (i < s.length()){

            if (i + 2 <= s.length()){
                String sub = s.substring(i, i+2);
                System.out.println(sub);
                if (SubstractionValue(sub)== 0){
                    toReturn += values(s.charAt(i));
                    i += 1;
                
                }else{
                    toReturn += SubstractionValue(sub);
                  i += 2;
                }

            }else{
                toReturn += values(s.charAt(i));
                i += 1;
            }

        }

        return toReturn;
        
    }

    // this will get a String of length two and we will chekc if there is a subtraction
    public int SubstractionValue(String s){

        switch(s){
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default:
                return 0;
        }
        
    }

    //gets a String of lenght 1 (or a char??)
    public int values (char c ){
        switch(c){
                    case 'I':
                        return 1;
                    case 'V':
                        return 5;
                    case 'X':
                        return 10;
                    case 'L':
                        return 50;
                    case 'C':
                        return 100;
                    case 'D':
                        return 500;
                    case 'M':
                        return 1000;
                    default:
                        System.out.println("Was ist hier los??");
                        return 0;
        }

    }

    public static void main(String [] args){

        String romanString = "III";
        String romanString2 = "LVIII";
        String romanString3 = "MCMXCIV";

        Solution mySolution = new Solution();

        int erg = mySolution.romanToInt(romanString);
        int erg2 = mySolution.romanToInt(romanString2);
        int erg3 = mySolution.romanToInt(romanString3);

        System.out.println(erg);
        System.out.println(erg2);
        System.out.println(erg3);

    }
}