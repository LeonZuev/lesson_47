package Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class CalculatorTests {

  // сложение положительных целых чисел
  @Test
  public void addPositiveIntegers() { // название теста
    // arrange - упорядочить, установить
    Calculator calc = new Calculator();

    // act - выполнить действие
    int result = calc.add(2,5);

    // assert - сравнить результат с правильным
    // assertEquals(expected, actual)
    // предположитьРавенство(ожиданиеб реальность)
    assertEquals(7, result);
  }
}
