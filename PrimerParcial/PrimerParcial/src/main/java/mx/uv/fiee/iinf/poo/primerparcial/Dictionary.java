package mx.uv.fiee.iinf.poo.primerparcial;
 
import java.io.*;
import java.util.ArrayList;
 
//diccionario generico que puede parsear JSON desde un String o un File
class Dictionary<T> implements JSONParser<T> {
 
    //aqui guardamos todos los elementos parseados
    private ArrayList<Entry<String, String>> entries = new ArrayList<>();
 
    @Override
    public void parse(T source) {
        String json = "";
 
        //si es un archivo lo leemos linea por linea
        if (source instanceof File) {
            try {
                BufferedReader br = new BufferedReader(new FileReader((File) source));
                StringBuilder sb = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    sb.append(linea);
                }
                br.close();
                json = sb.toString();
            } catch (Exception e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
                return;
            }
        } else if (source instanceof String) {
            //si ya es string lo usamos directo
            json = (String) source;
        }
 
        //quitamos las llaves del inicio y final
        entries.clear();
        if (json.startsWith("{")) json = json.substring(1);
        if (json.endsWith("}"))  json = json.substring(0, json.length() - 1);
 
        //separamos cada par clave:valor por la coma
        String[] pares = json.split(",");
        for (String par : pares) {
            par = par.trim();
 
            //buscamos el primer : para separar clave de valor
            int pos = par.indexOf(':');
            if (pos == -1) continue;

            String clave = par.substring(0, pos).trim().replace("\"", "");
            String valor = par.substring(pos + 1).trim().replace("\"", "");
 
            if (!clave.isEmpty() && !valor.isEmpty()) {
                entries.add(new Entry<>(clave, valor));
            }
        }
 
        //ordenamos de forma decendente por clave (z -> a)
        for (int i = 0; i < entries.size() - 1; i++) {
            for (int j = 0; j < entries.size() - i - 1; j++) {
                if (entries.get(j).key.compareTo(entries.get(j+1).key) < 0) {
                Entry temp = entries.get(j);
                entries.set(j, entries.get(j+1));
                entries.set(j+1, temp);
        }
    }
}
    }
 
    //retorna la lista de elementos almacenados
    public ArrayList<Entry<String, String>> elements() {
        return entries;
    }
}