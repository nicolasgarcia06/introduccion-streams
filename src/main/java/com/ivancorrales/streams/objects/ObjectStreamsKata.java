package com.ivancorrales.streams.objects;

import java.util.List;

/**
 * KATA: Streams con OBJETOS (playlist tipo Spotify)
 *
 * Normas:
 * - No uses for / while.
 * - Resuelve cada método encadenando operaciones de Stream.
 * - Piensa en receta: seleccionar → transformar → ordenar → recortar → resultado final.
 *
 * Qué vas a practicar aquí:
 * - filter(...)      : seleccionar canciones (por artista, rating, duración...)
 * - map(...)         : transformar Song -> String (título), Song -> int (seconds), Song -> double (rating)
 * - distinct()       : eliminar duplicados (depende de equals/hashCode de Song)
 * - sorted(...)      : ordenar por uno o varios criterios (Comparator)
 * - limit(n)         : quedarte con el TOP N
 * - mapToInt(...)    : pasar a IntStream y calcular sum/min/max/average
 * - mapToDouble(...) : pasar a DoubleStream y calcular average/max...
 * - findFirst/orElse : obtener “el primero” tras ordenar/filtrar, con valor por defecto
 * - collect(...)     : para construir texto (joining) o listas (si no usáis toList)
 *
 * Nota:
 * - Hay una canción repetida ("Refactor" - "Noa") a propósito para practicar distinct().
 */
public class ObjectStreamsKata {

    private final List<Song> playlist = List.of(
            new Song("Midnight Run", "Noa", 210, 4.6),
            new Song("Campus Life", "Leo", 180, 4.1),
            new Song("Refactor", "Noa", 240, 4.9),
            new Song("Bug Hunter", "Ana", 200, 3.8),
            new Song("Streams Day", "Leo", 195, 4.7),
            new Song("Refactor", "Noa", 240, 4.9), // repetida a propósito
            new Song("Clean Code", "Ana", 230, 4.2)
    );

    /**
     * NIVEL 1 (1 paso intermedio)
     * Cuenta cuántas canciones tienen rating >= 4.5.
     *
     * Requisitos:
     * - Cuenta también las repetidas si están en la lista.
     *
     * (Piensa: seleccionar → count)
     */
    public long contarRecomendadas() {
    	return playlist.stream()
                .filter(s -> s.getRating() >= 4.5)
                .count();
    }

    /**
     * NIVEL 2 (2 pasos intermedios)
     * Devuelve los títulos de las canciones de un artista dado.
     *
     * Requisitos:
     * - Respeta el orden original de la playlist.
     *
     * (Piensa: seleccionar por artista → transformar a títulos → lista)
     */
    public List<String> titulosDeArtista(String artista) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 3 (4 pasos intermedios)
     * Devuelve títulos con rating >= 4.5:
     * - sin repetidos (si una canción aparece duplicada, debe salir una vez)
     * - ordenados alfabéticamente
     *
     * (Piensa: seleccionar → distinct → map(título) → sorted → lista)
     */
    public List<String> titulosRecomendadosUnicosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 4 (ordenación por varios criterios + TOP)
     * Devuelve el TOP 2 de títulos, ordenando canciones así:
     * 1) rating descendente
     * 2) si empatan, duración (seconds) descendente
     *
     * Requisitos:
     * - Sin repetidos (usa distinct() antes del TOP).
     * - Devuelve SOLO los títulos (List<String>).
     *
     * (Piensa: distinct → sorted(criterios) → limit(2) → map(título) → lista)
     */
    public List<String> top2PorRatingLuegoDuracion() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 5 (IntStream)
     * Devuelve la duración total (suma de seconds) de la playlist.
     *
     * Requisitos:
     * - Incluye repetidas si están en la lista.
     *
     * (Piensa: mapToInt(seconds) → sum)
     */
    public int duracionTotal() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 6 (DoubleStream + average)
     * Devuelve la media de rating de TODA la playlist.
     *
     * Requisitos:
     * - Incluye repetidas si están en la lista.
     * - Si la playlist estuviera vacía, devuelve 0.0
     *
     * (Piensa: mapToDouble(rating) → average → orElse(0.0))
     */
    public double mediaRatingPlaylist() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 7 (joining)
     * Devuelve un CSV de títulos con rating >= 4.0:
     * - sin repetidos
     * - ordenados por artista y luego por título
     * - formato: "t1, t2, t3"
     *
     * (Piensa: seleccionar → distinct → ordenar → map(título) → joining(", "))
     */
    public String csvTitulosBuenosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    // -------------------------------------------------------------------------
    // EJERCICIOS EXTRA (sin Map) - suben dificultad poco a poco
    // -------------------------------------------------------------------------

    /**
     * EXTRA 1 (match)
     * Devuelve true si existe alguna canción con duración >= 240 segundos.
     *
     * (Piensa: ¿existe alguna...? → anyMatch)
     */
    public boolean hayCancionLarga() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * EXTRA 2 (min / findFirst)
     * Devuelve el título de la canción MÁS CORTA (menor seconds).
     * Si hay empate de duración, escoge la de título alfabéticamente primero.
     * Si la playlist estuviera vacía, devuelve "N/A".
     *
     * (Piensa: ordenar por seconds asc, luego título asc → findFirst → map(título) → orElse("N/A"))
     */
    public String tituloCancionMasCorta() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * EXTRA 3 (filter + sorted + limit)
     * Devuelve los 3 títulos con rating más alto de un artista dado (sin repetidos),
     * ordenados por rating desc y luego por título asc.
     *
     * Si el artista no tiene canciones, devuelve lista vacía.
     */
    public List<String> top3DeArtistaPorRating(String artista) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * EXTRA 4 (mapToInt + max)
     * Devuelve la duración máxima (seconds) de las canciones con rating >= 4.0.
     * Si no hay ninguna, devuelve 0.
     */
    public int duracionMaximaDeBuenas() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * EXTRA 5 (map + distinct + sorted)
     * Devuelve la lista de artistas únicos, ordenados alfabéticamente.
     *
     * (Piensa: map(artista) → distinct → sorted → lista)
     */
    public List<String> artistasUnicosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }
}