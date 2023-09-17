# Facility Location

El siguiente proyecto consiste en implementar un algoritmo goloso para una variante del problema <i>facility location</i>.

Un algoritmo goloso es el resultante de la búsqueda de optimización a problemas con alto nivel de complejidad computacional. Es un enfoque eficiente donde se busca encontrar la mejor solución posible a un problema dado. Los algoritmos golosos son útiles para encontrar una solución rápida y aproximada, pero no siempre garantizan la solución óptima.

Facility location es un problema recurrente en las operaciones y la logística. Se investiga la decisión de dónde ubicar una serie de instalaciones (almacenes, centros de distribución, fábricas, hospitales, etc) en un espacio geográfico para optimizar ciertos objetivos, como la reducción de costos operativos.

## Introducción

Tenemos un conjunto C de clientes que debemos atender, cada uno geo localizado con su latitud y longitud. Tenemos también un conjunto D de puntos donde podemos ubicar centros de distribución para los clientes. Estos puntos también están geo localizados con su latitud y longitud. Finalmente, tenemos una cantidad k máxima de centros de distribución que podemos abrir. Estos k centros de distribución deben ubicarse en k puntos del conjunto D.

Cada cliente será atendido desde el centro de distribución más cercano, y el costo de atenderlo es igual a la distancia en línea recta entre el cliente y su centro de distribución. El problema consiste en determinar qué subconjunto de k puntos de D se deben seleccionar para abrir centros de distribución, de modo tal que el costo total sea el menor posible.

## Algoritmo

La idea fue crear un algoritmo que vaya recorriendo por cada cliente todos los centros y, en cada recorrido, ir eliminando el centro de mayor distancia del cliente. De esta forma en cada recorrido se va reduciendo la cantidad de centros hasta el número k de centros abiertos que se sugieran.

En esta tabla se ve paso a paso las decisiones que toma el algoritmo. Cada fila es un recorrido que hace el algoritmo, y en cada recorrido elimina el punto de mayor distancia con el cliente del actual recorrido. (en rojo se muestra el centro eliminado en cada recorrido).

Centros que quiero abrir: k = 1 centro.

(imagen)

En este ejemplo, el primer recorrido muestra que el cliente 0 tiene al Punto 3 como el de mayor distancia. Luego, en el segundo recorrido, el cliente 1 recorre todos los puntos menos el excluído (Punto 3), y elimina también el de mayor distancia (Punto 4).

El centro obtenido es el Punto 1 y es el que tiene la segunda mejor distancia entre todos los clientes.

Además, como opción adicional, está la posibilidad de profundizar el resultado con una verificación extra. Esto se consigue recorriendo de forma inversa la lista de clientes con los puntos de los centros para luego comparar los kilómetros de la segunda búsqueda con la primera, y así se toma el resultado con menor distancia. Se tiene que considerar que esta segunda verificación dará a la aplicación un trabajo extra, afectando la optimización deseada, pero ampliando las posibilidades de un mejor resultado.

(imagen 2)

El centro obtenido es el punto 2 y, comparado con la primer búsqueda, este tiene menor distancia, y además es el mejor resultado de la tabla.
