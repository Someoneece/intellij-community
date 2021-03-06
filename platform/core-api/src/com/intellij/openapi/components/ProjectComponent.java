// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.openapi.components;

/**
 * No need to use this interface unless you need to listen to {@link #projectOpened} or {@link #projectClosed}.
 * Consider using {@link com.intellij.openapi.project.ProjectManager#TOPIC} or
 * if you need to run some activity on project open only, use {@link com.intellij.openapi.startup.StartupActivity} (marked with
 * {@link com.intellij.openapi.project.DumbAware} if possible to improve performance).
 *
 * <p>
 * <strong>Note that if you register a class as a project component it will be loaded, its instance will be created and
 * {@link #initComponent()} and {@link #projectOpened()} methods will be called for each project even if user doesn't use any feature of your
 * plugin. So consider using specific extensions instead to ensure that the plugin will not impact IDE performance until user calls its
 * actions explicitly.</strong>
 *
 * @deprecated Components are deprecated; please see http://www.jetbrains.org/intellij/sdk/docs/basics/plugin_structure/plugin_components.html for
 * guidelines on migrating to other APIs.
 */
@Deprecated
public interface ProjectComponent extends BaseComponent {
  /**
   * Invoked when the project corresponding to this component instance is opened.<p>
   * Note that components may be created for even unopened projects and this method can be never
   * invoked for a particular component instance (for example for default project).
   */
  default void projectOpened() {
  }

  /**
   * Invoked when the project corresponding to this component instance is closed.<p>
   * Note that components may be created for even unopened projects and this method can be never
   * invoked for a particular component instance (for example for default project).
   */
  default void projectClosed() {
  }
}
