package com.ivancorrales.streams.numbers;

import java.util.List;

/**
 * KATA: Streams con NÚMEROS (Integer) - progresiva
 *
 * Normas:
 * - No uses for / while.
 * - Cada método se resuelve encadenando operaciones de Stream.
 * - Lee cada enunciado como una “receta” de pasos: seleccionar → transformar → ordenar → recortar → resultado final.
 *
 * Operaciones que vas a practicar:
 * - filter(...)      : seleccionar elementos que cumplen una condición
 * - distinct()       : eliminar duplicados (ojo: mantiene el primer orden de aparición)
 * - sorted()         : ordenar ascendente (orden natural)
 * - sorted(reverse)  : ordenar descendente
 * - limit(n)         : quedarte con los N primeros
 * - mapToInt(...)    : pasar a IntStream (sum/average/min/max)
 * - findFirst()      : obtener el primero que cumpla (Optional) + orElse(valorPorDefecto)
 * - anyMatch(...)    : responder preguntas tipo “¿existe alguno...?”
 *
 * Nota importante:
 * - Los métodos que devuelven List deben devolver una nueva lista (no modificar datos originales).
 */
public class NumberStreamsKata {

    // Datos base: puntuaciones de gaming (hay repetidos y un valor negativo “ruido”)
    private final List<Integer> puntos = List.of(15, 42, 7, 42, 100, 3, -5, 18, 60, 60, 1);

    /**
     * Bonus flatMap: cada partida tiene varias rondas con puntuación.
     * Es una lista de listas para practicar "aplanar" con flatMap.
     */
    private final List<List<Integer>> rondasPorPartida = List.of(
            List.of(10, 20, -5),
            List.of(42, 7),
            List.of(100, 0, 5),
            List.of(18, 60, 60)
    );

    /**
     * NIVEL 1 (1 paso intermedio)
     * Devuelve SOLO los puntos positivos (> 0) manteniendo el orden original.
     *
     * (Piensa: seleccionar → lista)
     */
    public List<Integer> soloPositivos() {
    	return puntos.stream()
                .filter(p -> p > 0)
                .toList();
    }

    /**
     * NIVEL 2 (2 pasos intermedios)
     * Devuelve los puntos positivos (> 0) ordenados de menor a mayor (con repetidos).
     *
     * (Piensa: seleccionar → ordenar → lista)
     */
    public List<Integer> positivosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 3 (3 pasos intermedios)
     * Devuelve los puntos positivos (> 0) sin repetidos y ordenados ascendente.
     *
     * (Piensa: seleccionar → quitar repetidos → ordenar → lista)
     */
    public List<Integer> positivosUnicosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 4 (4 pasos intermedios)
     * Devuelve el TOP 3 de puntos MÁS ALTOS:
     * - solo positivos
     * - sin repetidos
     * - orden descendente
     * - quédate con 3
     *
     * (Piensa: seleccionar → quitar repetidos → ordenar desc → limit(3) → lista)
     */
    public List<Integer> top3UnicosDesc() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 5 (IntStream)
     * Devuelve la suma total de puntos positivos.
     *
     * Pista de receta: filter → mapToInt → sum
     */
    public int sumaPositivos() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 6 (findFirst + orElse)
     * Devuelve el primer punto múltiplo de 6 (respetando el orden original).
     * Si no existe, devuelve -1.
     *
     * Pista de receta: filter → findFirst → orElse(-1)
     */
    public int primerMultiploDe6Omenos1() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 7 (anyMatch)
     * Devuelve true si existe algún punto “legendario” (>= 100), false en caso contrario.
     *
     * (Piensa: ¿existe alguno...? → anyMatch)
     */
    public boolean hayLegendario() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 8 (IntStream + average)
     * Devuelve la media (double) de los puntos positivos.
     * Si no hay positivos, devuelve 0.0.
     *
     * Pista de receta: filter → mapToInt → average → orElse(0.0)
     */
    public double mediaPositivos() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 9 (IntStream + min/max)
     * Devuelve el rango de los positivos: (máximo - mínimo).
     * Si no hay positivos, devuelve 0.
     *
     * Consejo: puedes calcular min y max a partir de un IntStream,
     * pero recuerda que un stream no se puede “reutilizar” una vez consumido.
     */
    public int rangoPositivos() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 10 (flatMap “visual”)
     * Aplana rondasPorPartida en una sola lista de enteros.
     *
     * Requisitos:
     * - Mantén el orden original: primero todas las rondas de la partida 1, luego las de la 2, etc.
     *
     * (Piensa: List<List<Integer>> → Stream<Integer> usando flatMap)
     */
    public List<Integer> todasLasRondasEnUnaLista() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 11 (flatMap + receta completa)
     * Devuelve el TOP 5 de puntuaciones positivas únicas entre TODAS las rondas:
     * - aplanar todas las rondas
     * - quedarte con > 0
     * - sin repetidos
     * - orden descendente
     * - quédate con 5
     *
     * (Piensa: flatMap → filter → distinct → sorted desc → limit(5) → lista)
     */
    public List<Integer> top5UnicosPositivosDeTodasLasRondas() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 12 (flatMap + IntStream + sum)
     * Devuelve la suma total de todos los puntos positivos de TODAS las rondas.
     *
     * Pista de receta: flatMap → filter → mapToInt → sum
     */
    public int sumaPositivosDeTodasLasRondas() {
        throw new UnsupportedOperationException("TODO");
    }
}