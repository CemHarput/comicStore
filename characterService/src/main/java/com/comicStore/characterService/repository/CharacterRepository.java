package com.comicStore.characterService.repository;

import com.comicStore.characterService.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character,String> {
}
