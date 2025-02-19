package com.grupo7.progra3.service;

import com.grupo7.progra3.entity.SongEntity;
import com.grupo7.progra3.entity.SingerEntity;
import com.grupo7.progra3.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphService {
    private final SongRepository songRepository;
    private final Map<String, Set<String>> adjacencyList = new HashMap<>();

    @Autowired
    public GraphService(SongRepository songRepository) {
        this.songRepository = songRepository;
        buildGraph();
    }

    private void buildGraph() {
        songRepository.findAll().collectList().subscribe(songs -> {
            for (SongEntity song : songs) {
                adjacencyList.putIfAbsent(song.getTitle(), new HashSet<>());
                for (SingerEntity singer : song.getSingers()) {
                    adjacencyList.putIfAbsent(singer.getName(), new HashSet<>());
                    adjacencyList.get(song.getTitle()).add(singer.getName());
                    adjacencyList.get(singer.getName()).add(song.getTitle());
                }
            }
        });
    }

    public List<String> searchPath(String start, String end) {
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        if (backtrack(start, end, visited, path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean backtrack(String current, String target, Set<String> visited, List<String> path) {
        if (!adjacencyList.containsKey(current)) {
            return false;
        }
        path.add(current);
        visited.add(current);
        if (current.equals(target)) {
            return true;
        }
        for (String neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor) && backtrack(neighbor, target, visited, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public List<String> searchPathBFS(String start, String end) {
        if (!adjacencyList.containsKey(start) || !adjacencyList.containsKey(end)) {
            return Collections.emptyList();
        }

        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(Collections.singletonList(start));
        visited.add(start);

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String lastNode = path.get(path.size() - 1);

            if (lastNode.equals(end)) {
                return path;
            }

            for (String neighbor : adjacencyList.getOrDefault(lastNode, Collections.emptySet())) {
                if (!visited.contains(neighbor)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                    visited.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }
}
