package mx.uv.fiee.iinf.poo.primerparcial;

//clase que guarda cada par clave-valor del JSON
class Entry<K, V> {
    K key;
    V value;
 
    //constructor para inicializar la entrada
    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
 
    //para imprimir bonito cada entrada
    @Override
    public String toString() {
        return key + ": " + value;
    }
}
 