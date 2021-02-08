package com.meli.desafiospring.sortutil;

import com.meli.desafiospring.dto.article.ArticleDTO;
import com.meli.desafiospring.exceptions.BadRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Heapsort {

    public static List<ArticleDTO> sortArticleList(List<ArticleDTO> listArticles, Optional<Integer> typeOfSort){
        if(typeOfSort.isPresent()){
            Comparator comparator = null;
            switch (typeOfSort.get()){
                case 0:
                    comparator = new ComparatorNameAscImpl();
                    break;
                case 1:
                    comparator = new ComparatorNameDescImpl();
                    break;
                case 2:
                    comparator = new ComparatorPriceAscImpl();
                    break;
                case 3:
                    comparator = new ComparatorPriceDescImpl();
                    break;
                default:
                    throw new BadRequestException("El metodo de ordenamiento numero " + typeOfSort.get() + " no existe");
            }
                listArticles = sort(listArticles, comparator);
        }

        return listArticles;
    }

    public static <T> List<ArticleDTO> sort(List<ArticleDTO> listArticles, Comparator c) {
        List<ArticleDTO> list = new ArrayList<>();

        list.addAll(listArticles);

        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i, c);

        for (int i = n - 1; i > 0; i--) {
            ArticleDTO temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            heapify(list, i, 0, c);
        }
        return list;
    }

    static <T> void heapify(List<ArticleDTO> list,int n, int i, Comparator c)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && c.compare(list.get(l), list.get(largest)) > 0)
            largest = l;

        if (r < n && c.compare(list.get(r), list.get(largest)) > 0)
            largest = r;

        if (largest != i) {
            ArticleDTO swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            heapify(list, n, largest, c);
        }
    }

   /* public static void main(String[] args) {
        InfoArticleDTO a = new InfoArticleDTO();
        a.setName("sara");
        a.setPrice(100);

        InfoArticleDTO b = new InfoArticleDTO();
        b.setName("juan");
        b.setPrice(1400);

        InfoArticleDTO c = new InfoArticleDTO();
        c.setName("pedro");
        c.setPrice(400);

        InfoArticleDTO d = new InfoArticleDTO();
        d.setName("lucas");
        d.setPrice(4);

        List<InfoArticleDTO> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        for(InfoArticleDTO ab: list){
            System.out.print(ab.getName() + " ");
        }

        System.out.println();

        sort(list, new ComparatorPriceDescImpl());

        for(InfoArticleDTO ab: list){
            System.out.print(ab.getName()+ " ");
        }

    }*/
}
