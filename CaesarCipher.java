/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */

import java.util.Arrays;

public class CaesarCipher {

	private char[] ALPHABET = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        shift = 0;
        shifted = new char[26];
        shifter(0);
    }

    public CaesarCipher(int num){

        shift = num;        
        shifted = new char[26];
        shifter(shift);
    }

    public String encrypt(String message){
        String returnString="";
        boolean isItThere = false;

        for(int i=0; i<message.length(); i++){
            for(int letter=0; letter<ALPHABET.length; letter++)
                if(message.charAt(i)==(ALPHABET[letter])){ 
                    returnString+=(shifted[letter]);
                isItThere=true;}
        if(!isItThere)
            returnString+=message.charAt(i);

        isItThere = false;
         }
        return returnString;
    }

    public String decrypt(String message){
        String returnString = "";
        boolean isItThere = false;

        for(int i=0; i<message.length(); i++){
            for(int letter=0; letter<shifted.length; letter++){
                if(message.charAt(i)==(shifted[letter])){
                    returnString+=(ALPHABET[letter]);
                    isItThere=true;}
            }
            if(!isItThere)
                returnString+=message.charAt(i);

            isItThere=false;
        }
        return returnString;
    }

    public void shifter(int num){
        for(int i=0; i<ALPHABET.length; i++)
            shifted[(i+num)%26]=ALPHABET[i];
    
        /*{
        if(i-num<0)
            shifted[i]=ALPHABET[(i-num)+shifted.length];

        else
            shifted[i]=ALPHABET[i-num];
        }*/
    }

    public String toString(){
        System.out.println(Arrays.toString(ALPHABET));
        System.out.println(Arrays.toString(shifted));
        return "";
    }

}
