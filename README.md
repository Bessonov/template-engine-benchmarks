# Java template engine benchmark
This is a benchmark for java template engines. 
This is a fork of [greenlaw110's original work] (https://github.com/greenlaw110/template-engine-benchmarks).

The benchmark renders a list of the 20 stock ticker into [an HTML page](https://rawgithub.com/PerfectCarl/template-engine-benchmarks/master/output/stringbuilder.html).

The rendering is executed `1000 times` and its execution time is compared with [a baseline implementation](stringbuilder.md) using java's `StringBuilder`.


## Results 

| Engine                                 | Version     |   (The smaller the better) |
| -------------------------------------- |:-----------:|:------:|
| [StringBuilder](stringbuilder.md)      |    _        |   1.0x |
| [Httl](httl.md)  (3)                   |  1.0.7      |   0.9x |
| [Japid](japid.md)                      |  0.9.32     |   1.3x |
| [Rythm](rythm.md)                      |  1.0b11     |   1.6x |
| [Jamon](jamon.md)                      |  2.4.0      |   1.8x |
| [Velocity](velocity.md)                |  1.7        |   2.1x |
| [FreeMarker](freemarker.md)            |  2.3.19     |   3.0x |
| [Jme](jme.md)                          |  2.2        |   3.1x |
| [StringTemplate](stringtemplate.md)    |  4.0.7      |   4.7x |
| [Jangod](jangod.md)                    |             |  18.0x |
| [ThymeLeaf](thymeleaf.md)              |  2.0.15     |  26.7x |

(1) 

(2)

(3) 

## Tests

## More information 

The benchmark is compiled and executed with JDK 1.7.0_40-b43
The test have been executed on Windows 7 sp1 64 bits 

## How to 
