# T6----E2----Problemario-Metodos

### Equipo

- Gabriel Hernández Zavala
- Wenceslao Benitez Rosquero

  ## Método de un paso.
### Descripcion 

En métodos numéricos, el "método de un paso" se refiere a los métodos que utilizan la información de un solo punto anterior para calcular el siguiente punto en la solución de un problema. Estos métodos son particularmente útiles para la resolución de ecuaciones diferenciales ordinarias (EDO).

### Pseudocódigo 
```
Definir función f(x, y):
    retornar y - x

Definir método euler(x0, y0, xEnd, step):
    x = x0
    y = y0

    Imprimir "x =", x, ", y =", y

    Mientras x < xEnd hacer:
        y = y + step * f(x, y)
        x = x + step

        Imprimir "x =", x, ", y =", y

Definir método main:
    x0 = 0.0
    y0 = 1.0
    xEnd = 2.0
    step = 0.1

    Llamar a euler(x0, y0, xEnd, step)


```


### Implementacion 
- Implementacion en Python

```
def f(x, y):
    """
    Define la función f(x, y) que describe la EDO.
    En este caso, usaremos un ejemplo simple f(x, y) = y - x.
    """
    return y - x

def euler(x0, y0, x_end, step):
    """
    Implementa el Método de Euler para resolver la EDO.
    """
    x = x0
    y = y0

    # Imprimir el punto inicial
    print(f"x = {x:.4f}, y = {y:.4f}")

    # Iterar mientras x no haya alcanzado el valor final x_end
    while x < x_end:
        y = y + step * f(x, y)  # Aplicar el método de Euler para actualizar y
        x = x + step            # Incrementar x por el tamaño del paso

        # Imprimir el nuevo punto (x, y)
        print(f"x = {x:.4f}, y = {y:.4f}")

if __name__ == "__main__":
    # Valores iniciales y parámetros del método
    x0 = 0.0    # Valor inicial de x
    y0 = 1.0    # Valor inicial de y
    x_end = 2.0  # Valor final de x
    step = 0.1  # Tamaño del paso

    # Llamar al método de Euler
    euler(x0, y0, x_end, step)


```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDeUnPaso1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDeUnPaso2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDeUnPaso3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDeUnPaso4.java)

[Ejemplo 5](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDeUnPaso5.java)



==========================================================================

## Método de pasos múltiples.
### Descripcion 
El "método de pasos múltiples" es un enfoque utilizado en métodos numéricos para resolver ecuaciones diferenciales ordinarias (EDO). A diferencia de los métodos de un paso, que utilizan solo la información del punto anterior para calcular el siguiente punto, los métodos de pasos múltiples utilizan la información de varios puntos anteriores. Esto puede mejorar la precisión y eficiencia del cálculo.
Los métodos de pasos múltiples son herramientas poderosas en el análisis numérico para resolver EDOs, ofreciendo un equilibrio entre precisión y eficiencia. Sin embargo, su implementación y uso requieren un buen entendimiento de su comportamiento y estabilidad.


### Pseudocódigo 
```
// Definir la función f(t, y)
Función f(t, y):
    Retornar y - t^2 + 1

// Método de Adams-Bashforth de 2 pasos
Función adamsBashforth2(t0, y0, t1, y1, h):
    f0 = f(t0, y0)
    f1 = f(t1, y1)
    Retornar y1 + h * (1.5 * f1 - 0.5 * f0)

// Método de Adams-Moulton de 2 pasos (corrector)
Función adamsMoulton2(t0, y0, t1, y1, h, predictor):
    f0 = f(t0, y0)
    fp = f(t1 + h, predictor)
    f1 = f(t1, y1)
    Retornar y1 + h * (0.5 * (fp + f1))

// Función principal
Principal:
    Inicializar t0 = 0.0
    Inicializar y0 = 0.5
    Inicializar h = 0.1
    Inicializar steps = 10

    // Primer paso usando el método de Euler para obtener y1
    t1 = t0 + h
    y1 = y0 + h * f(t0, y0)

    Imprimir "t =", t0, ", y =", y0
    Imprimir "t =", t1, ", y =", y1

    // Pasos múltiples de Adams-Bashforth-Moulton
    Para i desde 2 hasta steps hacer:
        t2 = t1 + h
        predictor = adamsBashforth2(t0, y0, t1, y1, h)
        corrector = adamsMoulton2(t0, y0, t1, y1, h, predictor)

        Imprimir "t =", t2, ", y (predictor) =", predictor, ", y (corrector) =", corrector

        // Actualizar valores para el siguiente paso
        t0 = t1
        y0 = y1
        t1 = t2
        y1 = corrector


```


### Implementacion 
- Implementacion en Python

```

def f(t, y):
    """
    Define la función f(t, y) que describe la EDO.
    Ejemplo: dy/dt = y - t^2 + 1
    """
    return y - t * t + 1

def adams_bashforth2(t0, y0, t1, y1, h):
    """
    Método de Adams-Bashforth de 2 pasos.
    """
    f0 = f(t0, y0)
    f1 = f(t1, y1)
    return y1 + h * (1.5 * f1 - 0.5 * f0)

def adams_moulton2(t0, y0, t1, y1, h, predictor):
    """
    Método de Adams-Moulton de 2 pasos (corrector).
    """
    f0 = f(t0, y0)
    fp = f(t1 + h, predictor)
    f1 = f(t1, y1)
    return y1 + h * (0.5 * (fp + f1))

def main():
    # Condiciones iniciales
    t0 = 0.0
    y0 = 0.5
    h = 0.1
    steps = 10

    # Primer paso usando el método de Euler para obtener y1
    t1 = t0 + h
    y1 = y0 + h * f(t0, y0)

    print(f"t = {t0:.4f}, y = {y0:.4f}")
    print(f"t = {t1:.4f}, y = {y1:.4f}")

    # Pasos múltiples de Adams-Bashforth-Moulton
    for i in range(2, steps + 2):
        t2 = t1 + h
        predictor = adams_bashforth2(t0, y0, t1, y1, h)
        corrector = adams_moulton2(t0, y0, t1, y1, h, predictor)

        print(f"t = {t2:.4f}, y (predictor) = {predictor:.4f}, y (corrector) = {corrector:.4f}")

        # Actualizar valores para el siguiente paso
        t0, y0 = t1, y1
        t1, y1 = t2, corrector

if __name__ == "__main__":
    main()


```


### Ejercicios en java

[Ejemplo 1](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDePasosMultiples1.java)

[Ejemplo 2](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDePasosMultiples2.java)

[Ejemplo 3](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDePasosMultiples3.java)

[Ejemplo 4](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDePasosMultiples4.java)

[Ejemplo 5](https://github.com/GABOHDEZ2001/T6----E2----Problemario-Metodos/blob/master/src/Problemario/MetodoDePasosMultiples5.java)


