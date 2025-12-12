package com.ivancorrales.streams.numbers;

import java.util.List;

/**
 * KATA: Streams con DECIMALES (Double) - progresiva
 *
 * Normas:
 * - No uses for / while.
 * - Resuelve cada método encadenando operaciones de Stream.
 * - Piensa en “receta”: seleccionar → transformar → ordenar → recortar → resultado final.
 *
 * Objetivo:
 * - Practicar DoubleStream: mapToDouble / average / max / sum
 * - Practicar conversión a IntStream: mapToInt (por ejemplo, segundos → milisegundos)
 * - BONUS: practicar flatMap con List<List<Double>> (aplanar datos por sesiones)
 *
 * Pistas rápidas:
 * - Seleccionar: filter(...)
 * - Quitar repetidos: distinct()
 * - Ordenar: sorted() o sorted(Comparator.reverseOrder())
 * - Pasar a DoubleStream: mapToDouble(...)
 * - Pasar a IntStream: mapToInt(...)
 * - Aplanar listas: flatMap(List::stream)
 */
public class DoubleStreamsKata {

    // Temática: tiempos/latencias (en segundos), con repetidos y “ruido” negativo
    private final List<Double> tiempos = List.of(2.5, 1.2, -0.5, 3.0, 2.5, 4.75, 1.2);

    // Temática: precios con 3 decimales para practicar redondeo (incluye un precio negativo “ruido”)
    private final List<Double> precios = List.of(9.999, 10.0, 4.555, 4.554, -1.0, 12.345);

    /**
     * BONUS flatMap: latencias por sesión (cada lista es una sesión de juego con varias mediciones).
     * Hay valores repetidos y algún negativo “ruido”, igual que en la lista simple.
     */
    private final List<List<Double>> tiemposPorSesion = List.of(
            List.of(1.2, 2.5, -0.5),
            List.of(4.75, 1.2),
            List.of(3.0, 2.5)
    );

    /**
     * NIVEL 1 (1 paso intermedio)
     * Devuelve los tiempos positivos (> 0) manteniendo el orden original.
     *
     * (Piensa: seleccionar → lista)
     */
    public List<Double> tiemposPositivos() {
    	 return tiempos.stream()
                 .filter(t -> t > 0)
                 .toList();
    }

    /**
     * NIVEL 2 (3 pasos intermedios)
     * Devuelve los tiempos positivos (> 0), sin repetidos y ordenados ascendente.
     *
     * (Piensa: seleccionar → quitar repetidos → ordenar → lista)
     */
    public List<Double> tiemposPositivosUnicosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 3 (4 pasos intermedios)
     * Devuelve el TOP 2 de tiempos más altos:
     * - solo positivos
     * - sin repetidos
     * - orden descendente
     * - quédate con 2
     *
     * (Piensa: seleccionar → distinct → ordenar desc → limit(2) → lista)
     */
    public List<Double> top2TiemposUnicosDesc() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 4 (DoubleStream + average)
     * Devuelve la media (double) de los tiempos positivos.
     * Si no hay tiempos positivos, devuelve 0.0
     *
     * Pista de receta: filter → mapToDouble → average → orElse(0.0)
     */
    public double mediaTiemposPositivos() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 5 (IntStream + sum)
     * Convierte tiempos positivos a milisegundos redondeados y devuelve la suma total.
     *
     * Ejemplos:
     * - 2.5  s → 2500 ms
     * - 4.75 s → 4750 ms
     *
     * Pista de receta: filter → mapToInt(t -> (int)Math.round(t * 1000)) → sum
     */
    public int sumaMilisegundosRedondeados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 6 (map + sorted)
     * Devuelve precios NO negativos (>= 0), redondeados a 2 decimales y ordenados ascendente.
     *
     * Redondeo recomendado:
     * - Math.round(x * 100.0) / 100.0
     *
     * (Piensa: seleccionar → transformar (redondear) → ordenar → lista)
     */
    public List<Double> preciosRedondeadosOrdenados() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 7 (DoubleStream + max)
     * Devuelve el precio máximo entre los >= 0.
     * Si no hay ninguno, devuelve 0.0
     *
     * Pista de receta: filter → mapToDouble → max → orElse(0.0)
     */
    public double precioMaximo() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 8 (flatMap “visual”)
     * Aplana tiemposPorSesion en una sola lista.
     *
     * Requisitos:
     * - Mantén el orden: primero sesión 1 completa, luego sesión 2, etc.
     *
     * (Piensa: List<List<Double>> → Stream<Double> usando flatMap)
     */
    public List<Double> todosLosTiemposDeTodasLasSesiones() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * NIVEL 9 (flatMap + receta completa + DoubleStream)
     * Devuelve la media de los tiempos positivos de TODAS las sesiones.
     *
     * Requisitos:
     * - aplanar todas las sesiones
     * - quedarte con > 0
     * - calcular la media
     * - si no hay positivos, devuelve 0.0
     *
     * Pista de receta: flatMap → filter → mapToDouble → average → orElse(0.0)
     */
    public double mediaTiemposPositivosDeTodasLasSesiones() {
        throw new UnsupportedOperationException("TODO");
    }
}