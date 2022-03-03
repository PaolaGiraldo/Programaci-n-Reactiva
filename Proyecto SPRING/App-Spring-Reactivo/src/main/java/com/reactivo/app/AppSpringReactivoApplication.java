package com.reactivo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.cert.CertificateParsingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

@SpringBootApplication
public class AppSpringReactivoApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(AppSpringReactivoApplication.class, args);
		//ejemploStreams1();
		//ejemploStream2();

		//ejemploOperacionesIntermedias(3,30);
		ejemploLeerArchivo();
	}

	private static void ejemploStreams1(){

		Stream<String> streamVacio = Stream.empty();

		if (streamVacio.count()<= 0){
			System.out.println("No hay elementos en el Stream");
		}


		Collection<String> coleccion = Arrays.asList("Juan","Anibal","Yesica");

		streamVacio = coleccion.stream();
		System.out.println("Elementos en el Stream " + streamVacio.count());


	}

	private static void ejemploStream2(){
		Stream<String>  streamGenerado = Stream.generate(() -> "Elemento").limit(5);
		//System.out.println("Stream de " + streamGenerado.count() + " elementos");
		System.out.println("Stream Generado");

		//Imprimir el contenido del stream Generado
		streamGenerado.forEach(System.out::println);

		Stream<Integer> streamIterado = Stream.iterate(40, n -> n + 2).limit(20);

		System.out.println("Stream Iterado");

		//Imprimir el contenido del stream Iterado
		streamIterado.forEach(System.out::println);

		IntStream streamEnteros = IntStream.range(1,3);
		System.out.println("Stream de doubles enteros");
		streamEnteros.forEach(System.out::println);
		LongStream streamLong = LongStream.rangeClosed(1,3);
		System.out.println("Stream de doubles longs");
		streamLong.forEach(System.out::println);

		Random random = new Random();

		DoubleStream streamDoubleAleatorio = random.doubles(3);
		System.out.println("Stream de doubles aleatorio");

		//Uso de operaciones intermedias: map y sorted
		streamDoubleAleatorio.map(elemento -> elemento*100).sorted().forEach(System.out::println);

	}

	private static void	ejemploOperacionesIntermedias(Integer elementosAOmitir, Integer limite){

		//Ejemplo con distinct
		Collection<String> listaNombres = Arrays.asList("Hugo","Pablo","Paco","Luis","Lina","Paco");
		Collection<String> listaApellidos = Arrays.asList("Perez","Lopez","Gomez","Luis","Lina");
		List<String> listaNombresDiferentes = listaNombres.stream()
												.distinct()
												.sorted()
												.collect(Collectors.toList());


		List<String> listaApellidosDiferentes = listaNombres.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());

		System.out.println(listaNombresDiferentes);

		//Ejemplo con FlatMap

		List<List<String>> listaCompuestaNombresApellidos = List.of(listaNombresDiferentes, listaApellidosDiferentes);
		System.out.println(listaCompuestaNombresApellidos);

		System.out.println(listaCompuestaNombresApellidos.stream().flatMap(Collection::stream).collect(Collectors.toList()));

		//Ejemplo con skip y limit
		List<Integer> listaNumeros = Stream.iterate(0,i -> i + 1)
										.filter(i -> i%2 == 0)
										//.skip(elementosAOmitir)
										.limit(limite)
										.collect(Collectors.toList());

		System.out.println(listaNumeros);

		List<Integer> listaNumeros1 = Stream.iterate(0,i -> i + 1)
				.filter(AppSpringReactivoApplication::esPrimo)
				//.skip(elementosAOmitir)
				.limit(limite)
				.collect(Collectors.toList());

		System.out.println(listaNumeros1);

	}


	private static boolean esPrimo(Integer numero){
		for (int j = 2; j < numero; j++){
			if(numero % j == 0){
				return false;
			}
		}
		return true;
	}

	private static void ejemploLeerArchivo() throws IOException {
		Path fileName = Path.of("C:\\Users\\lizegira\\Documents\\ProgramacionReactiva\\Proyecto SPRING\\App-Spring-Reactivo\\src\\main\\resources\\demo.txt");
		System.out.println(Files.getAttribute(fileName,"size"));
		String actual = Files.readString(fileName);
		System.out.println(actual);

	}



}
