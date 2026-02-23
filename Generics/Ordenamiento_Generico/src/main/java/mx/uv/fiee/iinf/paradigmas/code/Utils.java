package mx.uv.fiee.iinf.paradigmas.code;

public class Utils {

    public static int[] ordena(int[] arreglo) 
    {
        Integer[] boxed = new Integer[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) 
        {
            boxed[i] = arreglo[i];
        }

        quickSort(boxed, 0, boxed.length - 1);

        int[] resultado = new int[boxed.length];
        for (int i = 0; i < boxed.length; i++) 
        {
            resultado[i] = boxed[i];
        }
        return resultado;
    }

    public static float[] ordena(float[] arreglo) 
    {
        Float[] boxed = new Float[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) 
        {
            boxed[i] = arreglo[i];
        }

        quickSort(boxed, 0, boxed.length - 1);

        float[] resultado = new float[boxed.length];
        for (int i = 0; i < boxed.length; i++) 
        {
            resultado[i] = boxed[i];
        }
        return resultado;
    }

    private static <T extends Number & Comparable<T>> void quickSort(T[] arr, int inicio, int fin) 
    {
        if (inicio < fin) 
        {
            int posPivote = particionar(arr, inicio, fin);
            quickSort(arr, inicio, posPivote - 1);
            quickSort(arr, posPivote + 1, fin);
        }
    }

    private static <T extends Number & Comparable<T>> int particionar(T[] arr, int inicio, int fin) 
    {
        T pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) 
        {
            if (arr[j].compareTo(pivote) <= 0) 
            {
                i++;
                intercambiar(arr, i, j);
            }
        }
        intercambiar(arr, i + 1, fin);
        return i + 1;
    }

    private static <T> void intercambiar(T[] arr, int i, int j) 
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void imprimir(int[] arreglo) 
    {
        System.out.print("[ ");
        for (int i = 0; i < arreglo.length; i++)
        {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }

    public static void imprimir(float[] arreglo) 
    {
        System.out.print("[ ");
        for (int i = 0; i < arreglo.length; i++) 
        {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }
}