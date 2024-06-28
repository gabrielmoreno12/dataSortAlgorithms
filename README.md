# Ordenações
### Gabriel Consul Moreno

### Sumário de Implementações:
- [BubbleSort](./src/BubbleSort.java)
- [SelectionSort](./src/SelectionSort.java)
- [QuickSort](./src/QuickSort.java)
- [MergeSort](./src/MergeSort.java)
- [HeapSort](./src/HeapSort.java)
- [ShellSort](./src/ShellSort.java)
#
Estratégia utilizada para erro de "StackOverFlow" para ordenação de arrays muito grandes utilizando QuickSort:

Versão Recursiva X Versão Iterativa

1. Implementação Recursiva:
- Pode levar a estouro de pilha (stack overflow) para conjuntos de dados muito grandes devido à profundidade da recursão (o que ocorre apartir do array com 65536 elementos).

Solução: Implementação Iterativa:
- Usa uma pilha para simular a recursão, empilhando e desempilhando intervalos de índices.
- Evita estouro de pilha que pode ocorrer na versão recursiva para grandes conjuntos de dados.
- Utiliza um loop while para iterar enquanto a pilha não estiver vazia, empurrando intervalos de índices para ordenação.
- Utiliza o método partition de maneira semelhante à versão recursiva para rearranjar o array em torno de um pivô.

#
### Cenário 1: Array ordenado em ordem crescente sem valores repetidos

| Tamanho do array (n) | Bubble Sort (ns) | Insertion Sort (ns) | Selection Sort (ns) | Heap Sort (ns) | Shell Sort (ns) | Merge Sort (ns) | Quick Sort (ns) |
|----------------------|------------------|---------------------|---------------------|----------------|-----------------|-----------------|-----------------|
| 128                  | 22000            | 13300               | 372300              | 195400         | 21500           | 53900           | 931000          |
| 256                  | 12200            | 10800               | 1102400             | 148100         | 49500           | 203100          | 2113300         |
| 512                  | 21800            | 21900               | 1982600             | 287300         | 92800           | 107100          | 3070300         |
| 1024                 | 52900            | 40900               | 2868600             | 232900         | 178100          | 207100          | 6429400         |
| 2048                 | 61000            | 67500               | 12817400            | 501000         | 460000          | 1278200         | 9970300         |
| 4096                 | 177300           | 139500              | 10324000            | 613900         | 1312800         | 3329900         | 33802400        |
| 8192                 | 248300           | 287000              | 32098500            | 1216500        | 997100          | 2172500         | 164230800       |
| 16384                | 506300           | 548400              | 111549800           | 2789800        | 1119400         | 6573300         | 463546500       |
| 32768                | 1055900          | 1049000             | 486241300           | 5205700        | 491900          | 11728000        | 1881434300      |
| 65536                | 420000           | 455600              | 1655851500          | 9737100        | 765600          | 7127900         | 7105645200      |

#

### Tempo médio de execução no cenário 1:

| Algoritmo        | Tempo Médio (ns) |
|------------------|------------------|
| BubbleSort       | 322040           |
| InsertionSort    | 324340           |
| SelectionSort    | 214289720        |
| HeapSort         | 1833080          |
| ShellSort        | 550570           |
| MergeSort        | 6317600          |
| QuickSort        | 956947200        |

#

### Cenário 2: Array ordenado em ordem decrescente com valores repetidos

| Tamanho do array (n) | Bubble Sort (ns) | Insertion Sort (ns) | Selection Sort (ns) | Heap Sort (ns) | Shell Sort (ns) | Merge Sort (ns) | Quick Sort (ns) |
|----------------------|------------------|---------------------|---------------------|----------------|-----------------|-----------------|-----------------|
| 128                  | 718500           | 89900               | 290100              | 9100           | 50100           | 527900          | 358300          |
| 256                  | 2473600          | 297700              | 172500              | 23200          | 114500          | 113100          | 318900          |
| 512                  | 9876300          | 603500              | 658200              | 42700          | 42400           | 224900          | 959400          |
| 1024                 | 2871100          | 2081500             | 2626100             | 104900         | 75700           | 162700          | 4885400         |
| 2048                 | 10923700         | 7954300             | 2416500             | 222900         | 157200          | 287600          | 12854500        |
| 4096                 | 44913100         | 32410100            | 8376800             | 389600         | 471500          | 2171600         | 18878700        |
| 8192                 | 189202200        | 128791600           | 33825100            | 757300         | 490000          | 2070300         | 70849800        |
| 16384                | 711277700        | 526419900           | 136156300           | 1578800        | 709800          | 1264500         | 271449300       |
| 32768                | 2808831300       | 2095698900          | 551982200           | 3339000        | 1469400         | 2622200         | 1256268200      |
| 65536                | 12440009800      | 9351797900          | 2532790900          | 8085400        | 3169300         | 9638900         | 5336988900      |

#

### Tempo médio de execução no cenário 2:

| Algoritmo       | Tempo Médio (ns) |
|-----------------|------------------|
| BubbleSort      | 462811144        |
| InsertionSort   | 1181609030       |
| SelectionSort   | 255349670        |
| HeapSort        | 1411130          |
| ShellSort       | 638250           |
| MergeSort       | 1797790          |
| QuickSort       | 684508480        |

#

### Cenário 3: Array aleatória sem valores repetidos

| Tamanho do array (n) | Bubble Sort (ns) | Insertion Sort (ns) | Selection Sort (ns) | Heap Sort (ns) | Shell Sort (ns) | Merge Sort (ns) | Quick Sort (ns) |
|----------------------|------------------|---------------------|---------------------|----------------|-----------------|-----------------|-----------------|
| 128                  | 56800            | 19200               | 13100               | 8700           | 7700            | 12200           | 69200           |
| 256                  | 178500           | 84600               | 49000               | 22400          | 22300           | 28900           | 109800          |
| 512                  | 609700           | 280900              | 149500              | 45100          | 42800           | 54900           | 123000          |
| 1024                 | 2671500          | 1119300             | 730900              | 105600         | 100400          | 113000          | 199100          |
| 2048                 | 11023900         | 4400400             | 3151700             | 241300         | 249300          | 281400          | 336500          |
| 4096                 | 45631800         | 16690600            | 12979600            | 516600         | 559900          | 536000          | 569700          |
| 8192                 | 193684400        | 77896800            | 53014200            | 1189400        | 1298100         | 1141800         | 1371800         |
| 16384                | 907189700        | 304242800           | 201190300           | 2870600        | 3056400         | 2481600         | 2854100         |
| 32768                | 4569709400       | 1249688400          | 949685000           | 5924800        | 7080000         | 5285100         | 5447300         |
| 65536                | 21862116300      | 5347123400          | 4708543900          | 13680900       | 18197700        | 11551800        | 14990300        |

#

### Tempo médio de execução no cenário 3:

| Algoritmo        | Tempo Médio (ns) |
|------------------|------------------|
| BubbleSort       | 683363688        |
| InsertionSort    | 687607550        |
| SelectionSort    | 506320300        |
| HeapSort         | 2480960          |
| ShellSort        | 3024210          |
| MergeSort        | 2225440          |
| QuickSort        | 3006080          |

#

### Cenário 4:  Array aleatória com valores repetidos

| Tamanho do array (n) | Bubble Sort (ns) | Insertion Sort (ns) | Selection Sort (ns) | Heap Sort (ns) | Shell Sort (ns) | Merge Sort (ns) | Quick Sort (ns) |
|----------------------|------------------|---------------------|---------------------|----------------|-----------------|-----------------|-----------------|
| 128                  | 858100           | 253500              | 305400              | 109400         | 83700           | 121400          | 94400           |
| 256                  | 497600           | 164700              | 198300              | 67500          | 153900          | 53100           | 58100           |
| 512                  | 1901600          | 564400              | 659200              | 93400          | 81500           | 94900           | 111200          |
| 1024                 | 6102500          | 2193600             | 2666300             | 196300         | 167300          | 193800          | 208300          |
| 2048                 | 18280100         | 3539000             | 6888300             | 417600         | 356700          | 400600          | 454400          |
| 4096                 | 75315400         | 15834800            | 26523700            | 554700         | 1339700         | 810100          | 909400          |
| 8192                 | 305854200        | 61038300            | 102130900           | 1047300        | 1388100         | 1173800         | 1370400         |
| 16384                | 1448292400       | 242168700           | 411902800           | 2632900        | 3345400         | 2302800         | 3053700         |
| 32768                | 5769497100       | 965808000           | 1608457300          | 5581800        | 6366000         | 4622300         | 6141600         |
| 65536                | 24408711300      | 4036054800          | 6284589600          | 12567000       | 12613800        | 9130200         | 12560800        |

#

### Tempo médio de execução no cenário 4:

| Algoritmo        | Tempo Médio (ns) |
|------------------|------------------|
| BubbleSort       | 948046177        |
| InsertionSort    | 804027900        |
| SelectionSort    | 886540460        |
| HeapSort         | 2869090          |
| ShellSort        | 3619700          |
| MergeSort        | 2158450          |
| QuickSort        | 1960130          |

