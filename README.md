# T6----E2----Problemario-Metodos

### Equipo

- Gabriel Hernández Zavala
- Wenceslao Benitez Rosquero

  ## Método de un paso.
### Descripcion 

El método de interpolación de Lagrange es una técnica matemática utilizada para encontrar un polinomio que pase exactamente por un conjunto dado de puntos. Este método es especialmente útil cuando se tiene un conjunto de datos discretos y se desea construir un polinomio que los describa de manera precisa. 
trapecio para calcular el área bajo la curva.

### Pseudocódigo 
```
// Definir el procedimiento principal
Inicio
    // Definir los valores de x y y
    xValues <- [1.0, 3.0]
    yValues <- [2.0, 4.0]

    // Definir el punto a interpolar
    x <- 2.0

    // Llamar a la función lagrange para obtener el valor interpolado
    interpolatedValue <- lagrange(x, xValues, yValues)

    // Mostrar el valor interpolado
    Imprimir "El valor interpolado en x = " + x + " es " + interpolatedValue
Fin

// Definir la función lagrange que calcula el polinomio de Lagrange
Función lagrange(x, xValues, yValues) Devuelve Real
    // Inicializar el resultado
    resultado <- 0

    // Iterar sobre los valores de xValues
    Para i desde 0 hasta longitud(xValues) - 1 hacer
        // Inicializar el término de Lagrange para el i-ésimo valor
        término <- yValues[i]

        // Calcular el término de Lagrange
        Para j desde 0 hasta longitud(xValues) - 1 hacer
            Si j != i entonces
                término <- término * (x - xValues[j]) / (xValues[i] - xValues[j])
            FinSi
        FinPara

        // Sumar el término al resultado
        resultado <- resultado + término
    FinPara

    // Devolver el resultado final
    Devolver resultado
FinFunción

```


### Implementacion 
- Implementacion en Python

```
  def lagrange(x, x_values, y_values):
    result = 0
    for i in range(len(x_values)):
        term = y_values[i]
        for j in range(len(x_values)):
            if j != i:
                term *= (x - x_values[j]) / (x_values[i] - x_values[j])
        result += term
    return result

def main():
    x_values = [1.0, 3.0]  # Valores de x
    y_values = [2.0, 4.0]  # Valores de y

    x = 2.0  # Punto a interpolar

    interpolated_value = lagrange(x, x_values, y_values)
    print(f"El valor interpolado en x = {x} es {interpolated_value}")

if __name__ == "__main__":
    main()



```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/TEMA-5---Interpolacion-y-ajuste-de-funciones-METODOS/blob/master/src/MetodoDeInterpolacionDeLagrange/MetodoDeInterpolacionDeLagrange4.java)



======================================================================================

