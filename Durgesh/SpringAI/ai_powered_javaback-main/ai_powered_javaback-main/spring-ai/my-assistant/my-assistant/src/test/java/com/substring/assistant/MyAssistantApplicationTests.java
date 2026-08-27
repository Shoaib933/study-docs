package com.substring.assistant;

import com.substring.assistant.service.DataLoader;
import com.substring.assistant.service.DataTransformer;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyAssistantApplicationTests {

    @Autowired
    private DataLoader dataLoader;
    @Autowired
    private DataTransformer dataTransformer;

    @Autowired
    private VectorStore vectorStore;

	@Test
	void contextLoads() {
	}

    @Test
    void testLoadData(){


        List<Document> documents = this.dataLoader.loadDocumentFromPdf();
        System.out.println(documents.size());
        List<Document> transformedData = dataTransformer.transformData(documents);
        System.out.println(transformedData.size());


        transformedData.forEach(document -> {
            System.out.println(document.getFormattedContent());
            System.out.println("-------------------------------------");
        });

        vectorStore.add(transformedData);
        System.out.println("document saved to db");



    }

}
