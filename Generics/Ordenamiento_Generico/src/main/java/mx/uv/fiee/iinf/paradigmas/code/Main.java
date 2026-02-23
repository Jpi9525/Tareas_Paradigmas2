package mx.uv.fiee.iinf.paradigmas.code;

public class Main {
    public static void main(String[] args) 
    {

        int[] intVector = {101, 99, 12, 19, 21, 111, 345, 25, 77, 81};
        int[] resultInt = Utils.ordena(intVector);
        Utils.imprimir(resultInt);

        float[] floatVector = {19.1f, 456.6f, 23.45f, 12.34f, 11.11f,354.55f, 78.45f, 28.33f, 45.99f, 108.88f};
        float[] resultFloat = Utils.ordena(floatVector);
        Utils.imprimir(resultFloat);

        //String [] strVector = {"zz", "aa", "cc", "hh", "bb", "ee", "ll"};
        //String [] resultStr = Utils.ordena (strVector);
    }
}