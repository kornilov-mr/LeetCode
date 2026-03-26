package hard;


import java.util.*;

/**
 * Delete Duplicate Folders in the System
 * <a href="https://leetcode.com/problems/delete-duplicate-folders-in-system/description/?envType=problem-list-v2&envId=hash-table">...</a>
 */
public class DeleteDuplicateFolders {
    public static final Map<String, ArrayList<FolderNode>> folderMap = new HashMap<>();

    public static void main(String[] args) {
        List<List<String>> paths = List.of(List.of("a","b"),List.of("c","d"),List.of("c"), List.of("a"));
        List<List<String>> newPaths = deleteDuplicateFolder(paths);
        System.out.println(newPaths);
    }

    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        FolderNode rootNode = buildTree(paths);
        DFSSearchFolder(rootNode);
        markAllFolderToDelete();
        return rootNode.getAllPathsExceptMarkedToDelete();
    }

    public static void markAllFolderToDelete() {
        for (List<FolderNode> folderNodes : folderMap.values()) {
            if (folderNodes.size() == 1)
                continue;
            for (FolderNode folderNode : folderNodes)
                folderNode.isMarkedToDelete = true;
        }
    }

    public static String DFSSearchFolder(FolderNode currNode) {
        if (currNode.isLeaf())
            return currNode.name;
        List<String> subFolderIdentifiers = new ArrayList<>();
        for (FolderNode child : currNode.children.values()) {
            subFolderIdentifiers.add(DFSSearchFolder(child));
        }
        String uniqueIdentifier = BuildUniqueIdentifier(subFolderIdentifiers);
        folderMap.putIfAbsent(uniqueIdentifier, new ArrayList<>());
        folderMap.get(uniqueIdentifier).add(currNode);
        return currNode.name+"/("+uniqueIdentifier+")";
    }

    public static String BuildUniqueIdentifier(List<String> subFolderIdentifiers) {
        subFolderIdentifiers.sort(String::compareTo);
        return String.join(",", subFolderIdentifiers);
    }

    public static FolderNode buildTree(List<List<String>> paths) {
        FolderNode rootNode = new FolderNode("",new ArrayList<>());
        for (List<String> path : paths) {
            FolderNode currNode = rootNode;
            List<String> currPath = new ArrayList<>();
            for (String folder : path) {
                currPath.add(folder);
                if (!currNode.hasChild(folder)) {
                    currNode.addChild(new FolderNode(folder, new ArrayList<>(currPath)));
                }
                currNode = currNode.getChild(folder);
            }
        }
        return rootNode;
    }

    private static class FolderNode {
        public final String name;
        public final List<String> path;
        public boolean isMarkedToDelete = false;
        public final Map<String,FolderNode> children = new HashMap<>();

        public FolderNode(String name,List<String> path) {
            this.name = name;
            this.path = path;
        }

        public List<List<String>> getAllPathsExceptMarkedToDelete() {
            List<List<String>> paths = new ArrayList<>();
            for(FolderNode child : children.values()){
                getAllPathsExceptMarkedToDelete(child, paths);
            }
            return paths;
        }

        public void getAllPathsExceptMarkedToDelete(FolderNode currNode, List<List<String>> paths) {
            if(currNode.isMarkedToDelete)
                return;
            paths.add(currNode.path);
            for (FolderNode child : currNode.children.values()) {
                getAllPathsExceptMarkedToDelete(child, paths);
            }
        }

        public void addChild(FolderNode child) {
            children.putIfAbsent(child.name, child);
        }

        public boolean isLeaf() {
            return children.isEmpty();
        }

        public boolean hasChild(String name) {
            return children.containsKey(name);
        }

        public FolderNode getChild(String name) {
            return children.get(name);
        }
    }
}
