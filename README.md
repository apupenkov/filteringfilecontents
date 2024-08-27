## Приветствую на странице утилиты для фильтрации содержимого файлов
### Эта маленькая утилита умеет:
* сортировать содержимое входных файлов на строки, целые числа и вещественные числа и раскладывать их по соответствующим файлам; 
* собирать статистику отфильтрованных данных, полную или краткую.

### Подготовка к работе
Перед тем как начать использовать данную утилиту, необходимо выполнить следующие шаги:
* скачать и установить Java jre 17 или Java jdk 17;  
* добавить путь к java в переменные среды;
* скачать файл filter.jar из папки /jarfile данного репозитория и поместить в любое место на вашем ПК. 

### Запуск
Чтобы запустить утилиту, необходимо последовательно выполнить следующие шаги:
* открыть командную строку;
* выполнить команду chcp 65001, чтобы поменять кодировку консоли на UTF-8;
* перейти в каталог с файлом filter.jar;
* выполнить команду java -jar filter.jar input.txt с флагами (о них подробнее ниже) или без, где input.txt - название файла, данные которого необходимо отфильтровать.

### Флаги

| Название | Описание|
| :--- | :--- |
| -o | Указывает путь к каталогу с результатами выполнения утилиты. Если не указан, файлы будут сгенерированы в том же каталоге. Пример: -o /results |
| -p | Добавляет префикс названий файлов с результатами. Если не выбран, будут сгенерированы названия файлов по умолчанию. Пример: -p result_ |
| -a | Добавляет отфильтрованные данные в файлы с результатами. По умолчанию файлы результатов перезаписываются |
| -s | Выводит статистику по количеству записей строк, целых чисел и вещественных чисел |
| -f | Выводит: <ul><li>статистику по количеству записей строк, целых чисел и вещественных чисел;</li><li>наибольшие и наименьшие целое и вещественное числа;</li><li>суммы целых и вещественных чесел;</li><li>средние значения целых и вещественных чисел;</li><li>наибольшую и наименьшую строки</li></ul> |
