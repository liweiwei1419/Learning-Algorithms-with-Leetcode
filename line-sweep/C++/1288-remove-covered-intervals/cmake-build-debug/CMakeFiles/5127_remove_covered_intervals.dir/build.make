# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.10

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/5127_remove_covered_intervals.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/5127_remove_covered_intervals.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/5127_remove_covered_intervals.dir/flags.make

CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o: CMakeFiles/5127_remove_covered_intervals.dir/flags.make
CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o -c /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/main.cpp

CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/main.cpp > CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.i

CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/main.cpp -o CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.s

CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.requires:

.PHONY : CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.requires

CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.provides: CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.requires
	$(MAKE) -f CMakeFiles/5127_remove_covered_intervals.dir/build.make CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.provides.build
.PHONY : CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.provides

CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.provides.build: CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o


# Object files for target 5127_remove_covered_intervals
5127_remove_covered_intervals_OBJECTS = \
"CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o"

# External object files for target 5127_remove_covered_intervals
5127_remove_covered_intervals_EXTERNAL_OBJECTS =

5127_remove_covered_intervals: CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o
5127_remove_covered_intervals: CMakeFiles/5127_remove_covered_intervals.dir/build.make
5127_remove_covered_intervals: CMakeFiles/5127_remove_covered_intervals.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable 5127_remove_covered_intervals"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/5127_remove_covered_intervals.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/5127_remove_covered_intervals.dir/build: 5127_remove_covered_intervals

.PHONY : CMakeFiles/5127_remove_covered_intervals.dir/build

CMakeFiles/5127_remove_covered_intervals.dir/requires: CMakeFiles/5127_remove_covered_intervals.dir/main.cpp.o.requires

.PHONY : CMakeFiles/5127_remove_covered_intervals.dir/requires

CMakeFiles/5127_remove_covered_intervals.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/5127_remove_covered_intervals.dir/cmake_clean.cmake
.PHONY : CMakeFiles/5127_remove_covered_intervals.dir/clean

CMakeFiles/5127_remove_covered_intervals.dir/depend:
	cd /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/cmake-build-debug /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/cmake-build-debug /Users/liwei/Desktop/workspace/c++/5127-remove-covered-intervals/cmake-build-debug/CMakeFiles/5127_remove_covered_intervals.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/5127_remove_covered_intervals.dir/depend
