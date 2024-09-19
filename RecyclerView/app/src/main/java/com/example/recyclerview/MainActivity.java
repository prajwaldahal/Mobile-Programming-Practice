package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        CustomAdapter customAdapter= new CustomAdapter(MainActivity.this,getInfo());
        recyclerView.setAdapter(customAdapter);
    }

    public ArrayList<Information> getInfo(){
        ArrayList<Information>informations= new ArrayList<>();

        String []info={
                "A ship is a large watercraft that serves various purposes, such as transportation, commerce, exploration, and military operations. There are different types of ships designed for specific roles. Cargo ships are built to transport goods and cargo across long distances, facilitating global trade. Passenger ships are designed to carry people, whether for transportation purposes, cruises, or tourism. Naval ships are military vessels used by navies for defense, combat, and maritime operations. Fishing vessels are dedicated to commercial fishing activities, equipped with specialized gear and storage facilities to support the fishing industry. These are just a few examples of the diverse range of ships that navigate the world's waterways, contributing to various industries and serving vital roles in global connectivity and security.",
                "The violin is a popular and versatile string instrument known for its melodic and expressive qualities. With its four strings and characteristic hourglass shape, the violin produces a rich and resonant sound when played with a bow. It is widely used in classical music, but it also finds its place in various genres, including folk, jazz, and contemporary music. The violin requires dedicated practice and skill to master, as players use their fingers to press the strings and manipulate the bow to produce a wide range of tones and dynamics. Its captivating sound and ability to convey emotions make the violin a beloved instrument cherished by musicians and audiences alike.",
                "A lighthouse is a tall structure with a powerful light at the top, designed to guide and warn ships at sea. These iconic maritime landmarks serve as beacons, helping ships navigate safely along coastlines and through hazardous areas. Lighthouses play a crucial role in maritime safety, providing visual references, especially during low visibility or at night. Their distinctive structures and powerful lights have made them significant symbols of hope, guidance, and maritime history.",
                "A bridge is a remarkable engineering structure that connects two separate points, spanning over obstacles such as rivers, valleys, or roads. These architectural marvels serve as crucial transportation links, enabling the seamless flow of people, vehicles, and goods between different locations. Bridges come in various forms and designs, including suspension bridges, beam bridges, arch bridges, and cable-stayed bridges, each tailored to specific needs and environmental conditions. They showcase the ingenuity of human creativity and the mastery of structural engineering. Beyond their practical function, bridges often embody symbolic significance, representing unity, progress, and the triumph of human ambition. As enduring structures that blend functionality and aesthetic appeal, bridges stand as testament to human innovation and our ability to overcome physical barriers in the pursuit of connectivity and progress.",
                "The whale is an awe-inspiring marine mammal that inhabits the world's oceans. As the largest known creature on Earth, whales captivate our imagination with their immense size and gentle nature. These majestic creatures are highly adapted to their aquatic environment, with streamlined bodies, powerful tails, and the ability to communicate through hauntingly beautiful songs. Whales play a crucial role in marine ecosystems, contributing to the balance of oceanic food chains. Despite facing numerous challenges, including threats from pollution and habitat loss, whales continue to inspire us with their grace and mystery.",
                "Birds are fascinating creatures that encompass a remarkable diversity of species worldwide. From the soaring majesty of eagles to the colorful plumage of tropical parrots, birds capture our attention and admiration with their ability to fly. These feathered creatures are equipped with unique adaptations, such as beaks suited for different diets, keen eyesight, and intricate songs. Birds occupy diverse habitats across the globe, ranging from dense forests to open grasslands and bustling urban environments. They serve essential ecological roles as pollinators, seed dispersers, and indicators of environmental health, making them a vital part of our natural world.",
                "The apple is a widely cherished fruit, known for its crisp texture, juicy flesh, and delightful sweetness. This versatile fruit comes in a variety of colors, sizes, and flavors, offering a delightful range of tastes for every palate. Apples have been cultivated for centuries and hold cultural significance in many societies. Beyond their deliciousness, apples are a rich source of nutrients, providing dietary fiber, antioxidants, and vitamins. Whether enjoyed fresh, baked into pies, or pressed into refreshing cider, apples continue to be a beloved and healthy treat that brings joy to people of all ages.",
                "Cats are beloved domesticated animals that have charmed humans for thousands of years. As independent and curious creatures, they possess a unique blend of grace, agility, and affection. Cats come in various breeds, each with its own distinctive characteristics and traits. Known for their exceptional grooming habits, playful nature, and purring companionship, cats have become cherished companions in many households. With their keen senses, including sharp eyesight and acute hearing, cats are skilled hunters and agile climbers. Their mysterious and enigmatic demeanor adds to their allure, making them one of the most popular pets worldwide."
        };
        String[] url ={


                "https://farm7.staticflickr.com/6089/6115759179_86316c08ff_z_d.jpg",

                "https://farm2.staticflickr.com/1090/4595137268_0e3f2b9aa7_z_d.jpg",

                "https://farm3.staticflickr.com/2220/1572613671_7311098b76_z_d.jpg",

                "https://i.imgur.com/OnwEDW3.jpg",

                "https://farm9.staticflickr.com/8505/8441256181_4e98d8bff5_z_d.jpg",

                "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg",


                "https://farm8.staticflickr.com/7377/9359257263_81b080a039_z_d.jpg",

                "https://i.imgur.com/CzXTtJV.jpg"

        };


        for(int i=0;i< url.length;i++){
            Information information=new Information(i+1,url[i],info[i]);
            informations.add(information);
        }
        return informations;
    }
}