package mx.uv.fiee.iinf.paradigmas.code;

import java.util.Iterator;

// definir comportamiento de colección

public class MyMarvelCollection implements Iterable<Film>{
    public Film[] films;   // El único almacenamiento permitido
    public int size;       // Cuántos elementos reales hay actualmente
    public static final int MAX_CAPACITY = 100;

    // Constructor que recibe un array inicial
    public MyMarvelCollection(Film[] initialFilms) {
        this.films = new Film[MAX_CAPACITY];
        
        // Si viene un array inicial, lo copiamos elemento por elemento
        if (initialFilms != null) {
            for (int i = 0; i < initialFilms.length; i++) {
                this.films[i] = initialFilms[i];
            }
            this.size = initialFilms.length;
        } else {
            this.size = 0;
        }
    }

    public void add(Film film) {
        if (size >= MAX_CAPACITY) {
            System.out.println("Colección llena");
            return;
        }
        films[size] = film;
        size++;
    }

    @Override
    public Iterator<Film> iterator() {
        return new FilmIterator();
    }

    private class FilmIterator implements Iterator<Film> {

        private int cursor = 0; // Apunta al siguiente elemento a devolver

        @Override
        public boolean hasNext() {
            return cursor < size; // Hay más si el cursor no llegó al final
        }

        @Override
        public Film next() {
            Film film = films[cursor];
            cursor++; // Avanza para la próxima llamada
            return film;
        }
    }


}
